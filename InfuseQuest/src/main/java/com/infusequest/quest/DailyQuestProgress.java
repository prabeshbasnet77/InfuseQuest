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
     * Add progress to player's daily quest.
     */
    public void addProgress(UUID uuid, Quest quest, int amount) {

    if (uuid == null || quest == null || amount <= 0) {
        return;
    }


    try (Connection connection = plugin.getDatabase().getConnection()) {


        PreparedStatement select = connection.prepareStatement(
                "SELECT progress, completed " +
                "FROM daily_quests " +
                "WHERE uuid = ? AND quest_id = ?"
        );


        select.setString(1, uuid.toString());
        select.setString(2, quest.getId());


        ResultSet rs = select.executeQuery();



        if (!rs.next()) {
            return;
        }



        int currentProgress =
                rs.getInt("progress");


        boolean completed =
                rs.getBoolean("completed");



        if(completed){
            return;
        }



        int target =
                quest.getAmount();



        int newProgress =
                currentProgress + amount;



        if(newProgress >= target){

            newProgress = target;

        }



        boolean nowCompleted =
                newProgress >= target;




        PreparedStatement update = connection.prepareStatement(
                "UPDATE daily_quests " +
                "SET progress = ?, completed = ? " +
                "WHERE uuid = ? AND quest_id = ?"
        );



        update.setInt(1,newProgress);
        update.setBoolean(2,nowCompleted);
        update.setString(3,uuid.toString());
        update.setString(4,quest.getId());



        update.executeUpdate();




        if(nowCompleted){

            rewardEssence(
                    uuid,
                    quest.getReward()
            );

        }



    } catch(Exception e){
        e.printStackTrace();
    }

    }

    /**
     * Reward essence to a player. Minimal implementation to avoid unresolved method error.
     */
    private void rewardEssence(UUID uuid, int amount) {
        // Placeholder: actual reward logic should be implemented as needed.
        // Currently does nothing to keep compilation and flow intact.
    }

}