package com.infusequest.listener;

import com.infusequest.InfuseQuest;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.PreparedStatement;

public class PlayerJoinListener implements Listener {


    private final InfuseQuest plugin;


    public PlayerJoinListener(InfuseQuest plugin) {

        this.plugin = plugin;

    }




    @EventHandler
    public void join(PlayerJoinEvent event) {


        /*
         * Create player database entry
         */
        try {


            PreparedStatement ps =
                    plugin.getDatabase()
                    .getConnection()
                    .prepareStatement(
                    """
                    INSERT OR IGNORE INTO players(uuid)
                    VALUES(?)
                    """
                    );



            ps.setString(
                    1,
                    event.getPlayer()
                    .getUniqueId()
                    .toString()
            );



            ps.executeUpdate();


            ps.close();



        } catch (Exception e) {


            e.printStackTrace();


        }





        /*
         * Load or generate daily quests
         * ONLY ONCE
         */
        var quests =
                plugin.getDailyQuestManager()
                .getQuests(event.getPlayer());





        /*
         * Debug message
         * Remove later if you don't want chat message
         */
        event.getPlayer().sendMessage(
                "§aToday's Daily Quests:"
        );



        quests.forEach(q ->
                event.getPlayer().sendMessage(
                        " §7- §f" + q.getQuestId()
                )
        );


    }



}