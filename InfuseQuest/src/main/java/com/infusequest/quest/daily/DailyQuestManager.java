package com.infusequest.quest.daily;


import com.infusequest.InfuseQuest;
import com.infusequest.database.DailyQuestRepository;
import com.infusequest.quest.Quest;


import org.bukkit.entity.Player;


import java.util.ArrayList;
import java.util.List;



public class DailyQuestManager {



    private final DailyQuestRepository repository;



    private final int DAILY_AMOUNT = 3;




    public DailyQuestManager(
            InfuseQuest plugin
    ){

        repository =
                new DailyQuestRepository(plugin);

    }






    public List<PlayerDailyQuest> getQuests(
            Player player
    ){



        if(repository.needsReset(player.getUniqueId())){

    repository.reset(player.getUniqueId());

}






        if(!quests.isEmpty()){


            return quests;


        }






        quests =
                new ArrayList<>();






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
                    player.getUniqueId(),
                    daily
            );



            quests.add(daily);



        }






        return quests;



    }





    public Quest getQuest(String id){

    for(Quest quest :
            DailyQuestPool.getAll()){


        if(quest.getId()
                .equalsIgnoreCase(id)){


            return quest;

        }


    }


    return null;

}



    public void updateProgress(
            Player player,
            String questID,
            int amount
    ){



        List<PlayerDailyQuest> quests =
                getQuests(player);




        for(PlayerDailyQuest quest : quests){


            if(
                    quest.getQuestId()
                    .equalsIgnoreCase(questID)

            ){



                quest.setProgress(
                        quest.getProgress()
                        + amount
                );



                repository.update(
                        player.getUniqueId(),
                        quest
                );



            }



        }




    }





}