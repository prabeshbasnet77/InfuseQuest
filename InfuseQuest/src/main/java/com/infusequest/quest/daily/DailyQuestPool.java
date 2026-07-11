package com.infusequest.quest.daily;

import com.infusequest.quest.Quest;
import com.infusequest.quest.QuestType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DailyQuestPool {

    private static final Random RANDOM = new Random();

    private static final List<Quest> QUESTS = new ArrayList<>();

    static {

        // --------------------------
        // Zombie
        // --------------------------

        QUESTS.add(new Quest(
                "kill_zombie_easy",
                "§aKill 20 Zombies",
                QuestType.KILL_ENTITY,
                "ZOMBIE",
                20,
                15
        ));

        QUESTS.add(new Quest(
                "kill_zombie_medium",
                "§aKill 50 Zombies",
                QuestType.KILL_ENTITY,
                "ZOMBIE",
                50,
                35
        ));

        QUESTS.add(new Quest(
                "kill_zombie_hard",
                "§aKill 100 Zombies",
                QuestType.KILL_ENTITY,
                "ZOMBIE",
                100,
                70
        ));

        // Skeleton

        QUESTS.add(new Quest(
                "kill_skeleton_easy",
                "§fKill 20 Skeletons",
                QuestType.KILL_ENTITY,
                "SKELETON",
                20,
                15
        ));

        QUESTS.add(new Quest(
                "kill_skeleton_medium",
                "§fKill 50 Skeletons",
                QuestType.KILL_ENTITY,
                "SKELETON",
                50,
                35
        ));

        QUESTS.add(new Quest(
                "kill_skeleton_hard",
                "§fKill 100 Skeletons",
                QuestType.KILL_ENTITY,
                "SKELETON",
                100,
                70
        ));

        // Creeper

        QUESTS.add(new Quest(
                "kill_creeper",
                "§2Kill 30 Creepers",
                QuestType.KILL_ENTITY,
                "CREEPER",
                30,
                25
        ));

        QUESTS.add(new Quest(
                "kill_spider",
                "§8Kill 40 Spiders",
                QuestType.KILL_ENTITY,
                "SPIDER",
                40,
                30
        ));

        QUESTS.add(new Quest(
                "kill_enderman",
                "§5Kill 15 Endermen",
                QuestType.KILL_ENTITY,
                "ENDERMAN",
                15,
                40
        ));

        QUESTS.add(new Quest(
                "kill_witch",
                "§dKill 10 Witches",
                QuestType.KILL_ENTITY,
                "WITCH",
                10,
                45
        ));

        // -------------------------
        // Mining
        // -------------------------

        QUESTS.add(new Quest(
                "mine_stone",
                "§7Mine 256 Stone",
                QuestType.BREAK_BLOCK,
                "STONE",
                256,
                25
        ));

        QUESTS.add(new Quest(
                "mine_deepslate",
                "§8Mine 256 Deepslate",
                QuestType.BREAK_BLOCK,
                "DEEPSLATE",
                256,
                30
        ));

        QUESTS.add(new Quest(
                "mine_coal",
                "§0Mine 64 Coal Ore",
                QuestType.BREAK_BLOCK,
                "COAL_ORE",
                64,
                30
        ));

        QUESTS.add(new Quest(
                "mine_iron",
                "§fMine 48 Iron Ore",
                QuestType.BREAK_BLOCK,
                "IRON_ORE",
                48,
                40
        ));

        QUESTS.add(new Quest(
                "mine_gold",
                "§6Mine 32 Gold Ore",
                QuestType.BREAK_BLOCK,
                "GOLD_ORE",
                32,
                45
        ));

        QUESTS.add(new Quest(
                "mine_redstone",
                "§cMine 64 Redstone Ore",
                QuestType.BREAK_BLOCK,
                "REDSTONE_ORE",
                64,
                40
        ));

        QUESTS.add(new Quest(
                "mine_diamond",
                "§bMine 16 Diamond Ore",
                QuestType.BREAK_BLOCK,
                "DIAMOND_ORE",
                16,
                70
        ));

        QUESTS.add(new Quest(
                "mine_emerald",
                "§aMine 8 Emerald Ore",
                QuestType.BREAK_BLOCK,
                "EMERALD_ORE",
                8,
                80
        ));

    }

    public static List<Quest> getRandomQuests(int amount){

        List<Quest> copy = new ArrayList<>(QUESTS);

        List<Quest> result = new ArrayList<>();

        while(result.size() < amount && !copy.isEmpty()){

            int index = RANDOM.nextInt(copy.size());

            result.add(copy.remove(index));

        }

        return result;

    }

}