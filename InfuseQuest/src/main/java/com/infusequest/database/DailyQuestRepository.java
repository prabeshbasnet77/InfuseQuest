package com.infusequest.database;

import com.infusequest.InfuseQuest;
import com.infusequest.quest.daily.PlayerDailyQuest;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DailyQuestRepository {

    private final InfuseQuest plugin;

    public DailyQuestRepository(InfuseQuest plugin) {
        this.plugin = plugin;
    }

    public List<PlayerDailyQuest> load(UUID uuid) {

        List<PlayerDailyQuest> quests = new ArrayList<>();

        try {

            PreparedStatement ps = plugin.getDatabase()
                    .getConnection()
                    .prepareStatement(
                            """
                            SELECT *
                            FROM daily_quests
                            WHERE uuid=?
                            AND assigned_date=?
                            """
                    );

            ps.setString(1, uuid.toString());
            ps.setString(2, LocalDate.now().toString());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                PlayerDailyQuest quest =
                        new PlayerDailyQuest(
                                rs.getString("quest_id")
                        );

                quest.setProgress(
                        rs.getInt("progress")
                );

                quest.setClaimed(
                        rs.getInt("claimed") == 1
                );

                quests.add(quest);

            }

            rs.close();
            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return quests;

    }

    public void save(UUID uuid, PlayerDailyQuest quest) {

        try {

            PreparedStatement ps = plugin.getDatabase()
                    .getConnection()
                    .prepareStatement(
                            """
                            INSERT INTO daily_quests
                            (uuid,quest_id,progress,claimed,assigned_date)
                            VALUES(?,?,?,?,?)
                            """
                    );

            ps.setString(1, uuid.toString());
            ps.setString(2, quest.getQuestId());
            ps.setInt(3, quest.getProgress());
            ps.setInt(4, quest.isClaimed() ? 1 : 0);
            ps.setString(5, LocalDate.now().toString());

            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}