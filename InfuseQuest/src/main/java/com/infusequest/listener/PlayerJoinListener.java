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

        try {

            PreparedStatement ps = plugin.getDatabase()
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

        // Generate (or load) this player's daily quests
        plugin.getDailyQuestManager().getQuests(event.getPlayer());

        // Temporary debug message
        event.getPlayer().sendMessage("§aToday's Daily Quests:");

        plugin.getDailyQuestManager()
                .getQuests(event.getPlayer())
                .forEach(q ->
                        event.getPlayer().sendMessage(" §7- " + q.getQuestId())
                );
    }
}