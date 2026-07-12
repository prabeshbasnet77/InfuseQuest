package com.infusequest.quest.daily;


import com.infusequest.quest.Quest;
import com.infusequest.quest.QuestDifficulty;
import com.infusequest.quest.QuestType;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class DailyQuestPool {



    private static final List<Quest> QUESTS =
            new ArrayList<>();





    static {

        /*
=========================
MORE COMBAT QUESTS
=========================
*/


add(
        "spider_killer",
        "Spider Hunter",
        QuestType.KILL_ENTITY,
        "SPIDER",
        50,
        5,
        QuestDifficulty.MEDIUM
);


add(
        "zombie_army",
        "Zombie Army",
        QuestType.KILL_ENTITY,
        "ZOMBIE",
        150,
        10,
        QuestDifficulty.HARD
);


add(
        "skeleton_army",
        "Skeleton Army",
        QuestType.KILL_ENTITY,
        "SKELETON",
        150,
        10,
        QuestDifficulty.HARD
);


add(
        "piglin_warrior",
        "Piglin Warrior",
        QuestType.KILL_ENTITY,
        "PIGLIN",
        50,
        12,
        QuestDifficulty.HARD
);


add(
        "guardian_hunter",
        "Ocean Guardian",
        QuestType.KILL_ENTITY,
        "GUARDIAN",
        20,
        15,
        QuestDifficulty.HARD
);




/*
=========================
MORE MINING QUESTS
=========================
*/


add(
        "copper_miner",
        "Copper Collector",
        QuestType.BREAK_BLOCK,
        "COPPER_ORE",
        100,
        4,
        QuestDifficulty.EASY
);


add(
        "redstone_miner",
        "Redstone Collector",
        QuestType.BREAK_BLOCK,
        "REDSTONE_ORE",
        100,
        6,
        QuestDifficulty.MEDIUM
);


add(
        "lapis_miner",
        "Lapis Hunter",
        QuestType.BREAK_BLOCK,
        "LAPIS_ORE",
        50,
        6,
        QuestDifficulty.MEDIUM
);


add(
        "emerald_miner",
        "Emerald Hunter",
        QuestType.BREAK_BLOCK,
        "EMERALD_ORE",
        10,
        12,
        QuestDifficulty.HARD
);


add(
        "nether_miner",
        "Nether Miner",
        QuestType.BREAK_BLOCK,
        "NETHERRACK",
        500,
        5,
        QuestDifficulty.MEDIUM
);



/*
=========================
FARMING QUESTS
=========================
*/


add(
        "sugarcane_farmer",
        "Sugar Cane Farmer",
        QuestType.BREAK_BLOCK,
        "SUGAR_CANE",
        200,
        5,
        QuestDifficulty.MEDIUM
);


add(
        "cactus_farmer",
        "Cactus Farmer",
        QuestType.BREAK_BLOCK,
        "CACTUS",
        200,
        5,
        QuestDifficulty.MEDIUM
);


add(
        "bamboo_farmer",
        "Bamboo Farmer",
        QuestType.BREAK_BLOCK,
        "BAMBOO",
        300,
        6,
        QuestDifficulty.MEDIUM
);


add(
        "nether_farm",
        "Nether Wart Farmer",
        QuestType.BREAK_BLOCK,
        "NETHER_WART",
        100,
        8,
        QuestDifficulty.MEDIUM
);



/*
=========================
CRAFTING QUESTS
=========================
*/


add(
        "craft_master",
        "Crafting Master",
        QuestType.CRAFT,
        "ANY",
        200,
        10,
        QuestDifficulty.HARD
);


add(
        "weapon_creator",
        "Weapon Creator",
        QuestType.CRAFT,
        "SWORD",
        20,
        8,
        QuestDifficulty.MEDIUM
);


add(
        "armor_creator",
        "Armor Creator",
        QuestType.CRAFT,
        "ARMOR",
        10,
        10,
        QuestDifficulty.MEDIUM
);



/*
=========================
INFUSE POWER QUESTS
=========================
*/


add(
        "fire_trial",
        "🔥 Fire Trial",
        QuestType.KILL_ENTITY,
        "BLAZE",
        100,
        20,
        QuestDifficulty.HARD
);


add(
        "frost_trial",
        "❄ Frost Trial",
        QuestType.KILL_ENTITY,
        "STRAY",
        100,
        20,
        QuestDifficulty.HARD
);


add(
        "speed_trial",
        "⚡ Speed Trial",
        QuestType.WALK,
        "BLOCKS",
        30000,
        15,
        QuestDifficulty.HARD
);


add(
        "thunder_trial",
        "⚡ Thunder Trial",
        QuestType.KILL_ENTITY,
        "CREEPER",
        100,
        25,
        QuestDifficulty.LEGENDARY
);


add(
        "ocean_trial",
        "🌊 Ocean Trial",
        QuestType.KILL_ENTITY,
        "GUARDIAN",
        50,
        25,
        QuestDifficulty.LEGENDARY
);


add(
        "ender_trial",
        "Ender Trial",
        QuestType.KILL_ENTITY,
        "ENDERMAN",
        100,
        25,
        QuestDifficulty.LEGENDARY
);


        /*
        =========================
        EASY QUESTS
        =========================
        */


        add(
                "zombie_hunter",
                "Zombie Hunter",
                QuestType.KILL_ENTITY,
                "ZOMBIE",
                25,
                2,
                QuestDifficulty.EASY
        );


        add(
                "skeleton_hunter",
                "Skeleton Hunter",
                QuestType.KILL_ENTITY,
                "SKELETON",
                25,
                2,
                QuestDifficulty.EASY
        );


        add(
                "stone_miner",
                "Stone Miner",
                QuestType.BREAK_BLOCK,
                "STONE",
                256,
                2,
                QuestDifficulty.EASY
        );


        add(
                "coal_miner",
                "Coal Collector",
                QuestType.BREAK_BLOCK,
                "COAL_ORE",
                64,
                3,
                QuestDifficulty.EASY
        );


        add(
                "wheat_farmer",
                "Wheat Farmer",
                QuestType.BREAK_BLOCK,
                "WHEAT",
                100,
                3,
                QuestDifficulty.EASY
        );


        add(
                "animal_breeder",
                "Animal Breeder",
                QuestType.BREED,
                "ANY",
                10,
                3,
                QuestDifficulty.EASY
        );






        /*
        =========================
        MEDIUM QUESTS
        =========================
        */


        add(
                "creeper_destroyer",
                "Creeper Destroyer",
                QuestType.KILL_ENTITY,
                "CREEPER",
                20,
                5,
                QuestDifficulty.MEDIUM
        );


        add(
                "iron_miner",
                "Iron Miner",
                QuestType.BREAK_BLOCK,
                "IRON_ORE",
                100,
                5,
                QuestDifficulty.MEDIUM
        );


        add(
                "diamond_miner",
                "Diamond Miner",
                QuestType.BREAK_BLOCK,
                "DIAMOND_ORE",
                20,
                8,
                QuestDifficulty.MEDIUM
        );


        add(
                "gold_miner",
                "Gold Hunter",
                QuestType.BREAK_BLOCK,
                "GOLD_ORE",
                50,
                6,
                QuestDifficulty.MEDIUM
        );


        add(
                "fisherman",
                "Professional Fisherman",
                QuestType.FISH,
                "FISH",
                50,
                6,
                QuestDifficulty.MEDIUM
        );


        add(
                "builder",
                "Builder",
                QuestType.PLACE_BLOCK,
                "ANY",
                500,
                5,
                QuestDifficulty.MEDIUM
        );


        add(
                "explorer",
                "Explorer",
                QuestType.WALK,
                "BLOCKS",
                10000,
                7,
                QuestDifficulty.MEDIUM
        );








        /*
        =========================
        HARD QUESTS
        =========================
        */


        add(
                "enderman_hunter",
                "Enderman Slayer",
                QuestType.KILL_ENTITY,
                "ENDERMAN",
                25,
                12,
                QuestDifficulty.HARD
        );


        add(
                "mob_master",
                "Mob Master",
                QuestType.KILL_ENTITY,
                "HOSTILE",
                200,
                15,
                QuestDifficulty.HARD
        );


        add(
                "ancient_debris",
                "Nether Treasure",
                QuestType.BREAK_BLOCK,
                "ANCIENT_DEBRIS",
                5,
                15,
                QuestDifficulty.HARD
        );


        add(
                "master_builder",
                "Master Builder",
                QuestType.PLACE_BLOCK,
                "ANY",
                2000,
                15,
                QuestDifficulty.HARD
        );


        add(
                "nether_warrior",
                "Nether Warrior",
                QuestType.KILL_ENTITY,
                "BLAZE",
                50,
                15,
                QuestDifficulty.HARD
        );








        /*
        =========================
        LEGENDARY QUESTS
        =========================
        */


        add(
                "warden_slayer",
                "Warden Slayer",
                QuestType.KILL_ENTITY,
                "WARDEN",
                1,
                50,
                QuestDifficulty.LEGENDARY
        );


        add(
                "wither_destroyer",
                "Wither Destroyer",
                QuestType.KILL_ENTITY,
                "WITHER",
                1,
                40,
                QuestDifficulty.LEGENDARY
        );


        add(
                "diamond_master",
                "Diamond Master",
                QuestType.BREAK_BLOCK,
                "DIAMOND_ORE",
                100,
                30,
                QuestDifficulty.LEGENDARY
        );


        add(
                "world_explorer",
                "World Explorer",
                QuestType.WALK,
                "BLOCKS",
                50000,
                35,
                QuestDifficulty.LEGENDARY
        );




    }








    private static void add(

            String id,

            String name,

            QuestType type,

            String target,

            int amount,

            int essence,

            QuestDifficulty difficulty

    ){


        QUESTS.add(

                new Quest(

                        id,

                        name,

                        type,

                        target,

                        amount,

                        essence,

                        difficulty

                )

        );


    }









    public static List<Quest> getRandomQuests(
            int amount
    ){



        List<Quest> result =
                new ArrayList<>();



        List<Quest> copy =
                new ArrayList<>(QUESTS);



        Collections.shuffle(copy);





        // Try balanced selection


        Quest easy = null;

        Quest medium = null;

        Quest hard = null;

        Quest legendary = null;





        for(Quest quest : copy){


            if(
                    quest.getDifficulty()
                    == QuestDifficulty.EASY
                    && easy == null
            ){

                easy = quest;

            }



            if(
                    quest.getDifficulty()
                    == QuestDifficulty.MEDIUM
                    && medium == null
            ){

                medium = quest;

            }



            if(
                    quest.getDifficulty()
                    == QuestDifficulty.HARD
                    && hard == null
            ){

                hard = quest;

            }



            if(
                    quest.getDifficulty()
                    == QuestDifficulty.LEGENDARY
                    && legendary == null
            ){

                legendary = quest;

            }



        }






        if(amount >= 1 && easy != null)
            result.add(easy);



        if(amount >= 2 && medium != null)
            result.add(medium);



        if(amount >= 3 && hard != null)
            result.add(hard);





        while(result.size() < amount){


            for(Quest quest : copy){


                if(!result.contains(quest)){


                    result.add(quest);

                    break;


                }


            }


        }





        return result;


    }








    public static List<Quest> getAll(){


        return QUESTS;


    }



}