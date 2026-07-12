package com.infusequest.quest;

import java.util.ArrayList;
import java.util.List;


public class QuestPool {


    private final List<Quest> quests = new ArrayList<>();


    private boolean loaded = false;




    public QuestPool() {

        loadQuests();

    }





    /**
     * Get quest by ID
     */
    public Quest getQuest(String id) {


        if(id == null) {

            return null;

        }



        for(Quest quest : quests) {


            if(quest.getId()
                    .equalsIgnoreCase(id)) {


                return quest;

            }

        }


        return null;

    }





    /**
     * Load all quests
     */
    private void loadQuests() {


        if(loaded) {

            return;

        }



        loaded = true;



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



    }





    /**
     * Get all quests
     */
    public List<Quest> getAllQuests() {

        return quests;

    }



}