package com.infusequest.listener;

import com.infusequest.InfuseQuest;
import com.infusequest.quest.Quest;
import com.infusequest.quest.QuestLoader;
import com.infusequest.quest.QuestType;
import com.infusequest.quest.daily.DailyQuestManager;
import com.infusequest.quest.daily.DailyQuestProgress;
import com.infusequest.quest.daily.PlayerDailyQuest;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityKillListener implements Listener {

    private final InfuseQuest plugin;

    public EntityKillListener(InfuseQuest plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onKill(EntityDeathEvent event) {

        Player player = event.getEntity().getKiller();

        if (player == null) {
            return;
        }

        EntityType entity = event.getEntity().getType();

        DailyQuestManager manager = plugin.getDailyQuestManager();
        DailyQuestProgress progress = plugin.getDailyQuestProgress();

        for (PlayerDailyQuest dailyQuest : manager.getQuests(player)) {

            Quest quest = QuestLoader.getQuest(dailyQuest.getQuestId());

            if (quest == null) {
                continue;
            }

            if (quest.getType() != QuestType.KILL_ENTITY) {
                continue;
            }

            if (!quest.getTargetName().equalsIgnoreCase(entity.name())) {
                continue;
            }

            progress.addProgress(player, dailyQuest, quest);

        }

    }

}