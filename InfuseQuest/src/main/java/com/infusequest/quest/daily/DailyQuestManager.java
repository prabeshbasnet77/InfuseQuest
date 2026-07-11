package com.infusequest.quest.daily;

import com.infusequest.InfuseQuest;
import com.infusequest.database.DailyQuestRepository;
import com.infusequest.quest.Quest;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class DailyQuestManager {

    private final DailyQuestRepository repository;

    public DailyQuestManager(InfuseQuest plugin) {
        repository = new DailyQuestRepository(plugin);
    }

    public List<PlayerDailyQuest> getQuests(Player player) {

        List<PlayerDailyQuest> quests =
                repository.load(player.getUniqueId());

        if (!quests.isEmpty()) {
            return quests;
        }

        quests = new ArrayList<>();

        List<Quest> random =
                DailyQuestPool.getRandomQuests(3);

        for (Quest quest : random) {

            PlayerDailyQuest dailyQuest =
                    new PlayerDailyQuest(quest.getId());

            repository.save(
                    player.getUniqueId(),
                    dailyQuest
            );

            quests.add(dailyQuest);
        }

        return quests;
    }

    /**
     * Save updated progress.
     */
    public void save(Player player, PlayerDailyQuest quest) {

        repository.update(
                player.getUniqueId(),
                quest
        );

    }

}