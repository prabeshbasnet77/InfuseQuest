package com.infusequest.quest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestGenerator {

    private final QuestPool questPool;

    public QuestGenerator() {
        this.questPool = new QuestPool();
    }

    public List<PlayerQuest> generateDailyQuests(int amount) {

        List<Quest> pool = new ArrayList<>(questPool.getAllQuests());

        Collections.shuffle(pool);

        List<PlayerQuest> result = new ArrayList<>();

        for (int i = 0; i < amount && i < pool.size(); i++) {
            result.add(new PlayerQuest(pool.get(i)));
        }

        return result;
    }

    public QuestPool getQuestPool() {
        return questPool;
    }
}