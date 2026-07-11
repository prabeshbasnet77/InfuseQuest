package com.infusequest.listener;

import com.infusequest.InfuseQuest;
import com.infusequest.quest.DailyQuestManager;
import com.infusequest.quest.DailyQuestProgress;
import com.infusequest.quest.Quest;
import com.infusequest.quest.QuestType;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    private final InfuseQuest plugin;

    public BlockBreakListener(InfuseQuest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();

        Material block = event.getBlock().getType();

        DailyQuestManager manager = plugin.getDailyQuestManager();
        DailyQuestProgress progress = plugin.getDailyQuestProgress();

        for (Quest quest : manager.getPlayerQuests(player.getUniqueId())) {

            if (quest.getType() != QuestType.BREAK_BLOCK) {
                continue;
            }

            if (!quest.getTargetName().equalsIgnoreCase(block.name())) {
                continue;
            }

            progress.addProgress(
                    player.getUniqueId(),
                    quest,
                    1
            );
        }
    }

}