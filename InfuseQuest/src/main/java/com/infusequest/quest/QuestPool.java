package com.infusequest.quest;

import java.util.ArrayList;
import java.util.List;

public class QuestPool {

    private final List<Quest> quests = new ArrayList<>();

    public QuestPool() {
        loadQuests();
    }

    private void loadQuests() {

        // =========================
        // Zombie
        // =========================

        quests.add(new Quest(
                "kill_zombie_25",
                "§aZombie Hunter",
                QuestType.KILL_ENTITY,
                "ZOMBIE",
                25,
                150
        ));

        quests.add(new Quest(
                "kill_zombie_50",
                "§2Zombie Exterminator",
                QuestType.KILL_ENTITY,
                "ZOMBIE",
                50,
                300
        ));

        // =========================
        // Skeleton
        // =========================

        quests.add(new Quest(
                "kill_skeleton_20",
                "§fSkeleton Slayer",
                QuestType.KILL_ENTITY,
                "SKELETON",
                20,
                140
        ));

        quests.add(new Quest(
                "kill_skeleton_40",
                "§7Master Skeleton Slayer",
                QuestType.KILL_ENTITY,
                "SKELETON",
                40,
                280
        ));

        // =========================
        // Creeper
        // =========================

        quests.add(new Quest(
                "kill_creeper_15",
                "§aBoom Hunter",
                QuestType.KILL_ENTITY,
                "CREEPER",
                15,
                180
        ));

        quests.add(new Quest(
                "kill_creeper_30",
                "§2Explosion Expert",
                QuestType.KILL_ENTITY,
                "CREEPER",
                30,
                360
        ));

        // We'll continue adding quests in Phase 1.2 until we reach 50+
    }

    public List<Quest> getAllQuests() {
        return quests;
    }
}