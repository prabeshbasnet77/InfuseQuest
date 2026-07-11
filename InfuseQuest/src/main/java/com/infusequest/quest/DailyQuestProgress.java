package com.infusequest.quest;

import com.infusequest.InfuseQuest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

public class DailyQuestProgress {

    private final InfuseQuest plugin;

    public DailyQuestProgress(InfuseQuest plugin) {
        this.plugin = plugin;
    }

    /**
     * Add progress to a player's quest.
     */
    public void addProgress(UUID uuid, Quest quest, int amount) {

        try {

            Connection connection = plugin.getDatabase().getConnection();

            PreparedStatement select = connection.prepareStatement(
                    """
                    SELECT progress, completed
                    FROM daily_quests
                    WHERE uuid = ?
                    AND quest_id = ?
                    """
            );

            select.setString(1, uuid.toString());
            select.setString(2, quest.getId());

            ResultSet rs = select.executeQuery();

            if (!rs.next()) {
                return;
            }

            int progress = rs.getInt("progress");
            boolean completed = rs.getBoolean("completed");

            if (completed) {
                return;
            }

            progress += amount;

            boolean nowCompleted = progress >= quest.getTarget();

            PreparedStatement update = connection.prepareStatement(
                    """
                    UPDATE daily_quests
                    SET progress = ?,
                        completed = ?
                    WHERE uuid = ?
                    AND quest_id = ?
                    """
            );

            update.setInt(1, progress);
            update.setBoolean(2, nowCompleted);
            update.setString(3, uuid.toString());
            update.setString(4, quest.getId());

            update.executeUpdate();

            if (nowCompleted) {
                rewardEssence(uuid, quest.getReward());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Give Essence reward.
     */
    private void rewardEssence(UUID uuid, int amount) {

        try {

            Connection connection = plugin.getDatabase().getConnection();

            PreparedStatement statement = connection.prepareStatement(
                    """
                    UPDATE players
                    SET essence = essence + ?
                    WHERE uuid = ?
                    """
            );

            statement.setInt(1, amount);
            statement.setString(2, uuid.toString());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Get current progress.
     */
    public int getProgress(UUID uuid, String questId) {

        try {

            PreparedStatement statement =
                    plugin.getDatabase()
                            .getConnection()
                            .prepareStatement(
                                    """
                                    SELECT progress
                                    FROM daily_quests
                                    WHERE uuid = ?
                                    AND quest_id = ?
                                    """
                            );

            statement.setString(1, uuid.toString());
            statement.setString(2, questId);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getInt("progress");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;

    }

    /**
     * Check if completed.
     */
    public boolean isCompleted(UUID uuid, String questId) {

        try {

            PreparedStatement statement =
                    plugin.getDatabase()
                            .getConnection()
                            .prepareStatement(
                                    """
                                    SELECT completed
                                    FROM daily_quests
                                    WHERE uuid = ?
                                    AND quest_id = ?
                                    """
                            );

            statement.setString(1, uuid.toString());
            statement.setString(2, questId);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                return rs.getBoolean("completed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

}