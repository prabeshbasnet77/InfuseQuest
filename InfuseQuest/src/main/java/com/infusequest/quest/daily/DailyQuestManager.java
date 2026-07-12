package com.infusequest.quest.daily;


import com.infusequest.InfuseQuest;
import com.infusequest.database.DailyQuestRepository;
import com.infusequest.quest.Quest;


import org.bukkit.entity.Player;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;



public class DailyQuestManager {



    private final DailyQuestRepository repository;



    private final Map<UUID, List<PlayerDailyQuest>> playerQuests =
        new HashMap<>();



    private final int DAILY_AMOUNT = 3;






    public DailyQuestManager(
            InfuseQuest plugin
    ){

        repository =
                new DailyQuestRepository(plugin);

    }









    /**
     * Get player's daily quests.
     *
     * Priority:
     *
     * 1. Reset if new day
     * 2. Check memory cache
     * 3. Load from database
     * 4. Generate new quests
     */
    public List<PlayerDailyQuest> getQuests(
            Player player
    ){



        UUID uuid =
                player.getUniqueId();







        /*
         * DAILY RESET CHECK
         */

        if(repository.needsReset(uuid)){

    System.out.println(
            "[InfuseQuest DEBUG] DAILY RESET FOR "
            + player.getName()
    );


    repository.reset(uuid);

}


        










        /*
         * MEMORY CACHE
         */

        if(playerQuests.containsKey(uuid)){


            List<PlayerDailyQuest> cached =
                    playerQuests.get(uuid);



            if(cached != null &&
                    !cached.isEmpty()){


                return cached;

            }

        }









        /*
         * LOAD FROM DATABASE
         */

        List<PlayerDailyQuest> saved =
        repository.getPlayerQuests(uuid);


System.out.println(
        "[InfuseQuest DEBUG] DATABASE QUEST COUNT: "
        + saved.size()
);





        if(saved != null &&
                !saved.isEmpty()){



            playerQuests.put(

                    uuid,

                    saved

            );



            return saved;


        }









        /*
         * GENERATE NEW QUESTS
         */

        List<PlayerDailyQuest> generated =
                new ArrayList<>();




        System.out.println("[InfuseQuest] GENERATING NEW QUESTS FOR " + player.getName());

List<Quest> random =
        DailyQuestPool.getRandomQuests(
                DAILY_AMOUNT
        );







        for(Quest quest : random){



            PlayerDailyQuest daily =
                    new PlayerDailyQuest(
                            quest.getId()
                    );




            repository.save(

                    uuid,

                    daily

            );



            generated.add(daily);



        }









        /*
         * STORE CACHE
         */

        playerQuests.put(

                uuid,

                generated

        );





        return generated;


    }












    /**
     * Get quest details.
     */
    public Quest getQuest(
            String id
    ){



        for(Quest quest :
                DailyQuestPool.getAll()){


            if(quest.getId()
                    .equalsIgnoreCase(id)){


                return quest;


            }


        }



        return null;


    }












    /**
     * Update quest progress.
     */
    public void updateProgress(

            Player player,

            String questID,

            int amount

    ){



        UUID uuid =
                player.getUniqueId();




        List<PlayerDailyQuest> quests =
                getQuests(player);







        for(PlayerDailyQuest quest : quests){



            if(quest.getQuestId()
                    .equalsIgnoreCase(questID)){



                quest.setProgress(

                        quest.getProgress()
                                + amount

                );



                repository.update(

                        uuid,

                        quest

                );



                break;


            }


        }


    }












    /**
     * Admin/debug support.
     */
    public List<PlayerDailyQuest> getPlayerQuests(
            UUID uuid
    ){


        return repository.getPlayerQuests(uuid);


    }












    /**
     * Clear cache when player leaves.
     */
    public void clearPlayerCache(
            Player player
    ){


        playerQuests.remove(
                player.getUniqueId()
        );


    }



}