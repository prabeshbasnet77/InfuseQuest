package com.infusequest.quest.daily;

import org.bukkit.entity.Player;

import java.util.*;

public class DailyQuestManager {

    private final Map<UUID, List<PlayerDailyQuest>> playerQuests = new HashMap<>();

    public List<PlayerDailyQuest> getQuests(Player player) {

        UUID uuid = player.getUniqueId();

        if (!playerQuests.containsKey(uuid)) {

            generateQuests(player);

        }

        return playerQuests.get(uuid);

    }

    public void generateQuests(Player player) {

        UUID uuid = player.getUniqueId();

        List<PlayerDailyQuest> list = new ArrayList<>();

        DailyQuestPool.getRandomQuests(3).forEach(q ->

                list.add(new PlayerDailyQuest(q.getId()))

        );

        playerQuests.put(uuid, list);

    }

}
