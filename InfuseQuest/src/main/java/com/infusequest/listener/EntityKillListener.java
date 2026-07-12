package com.infusequest.listener;

import com.infusequest.InfuseQuest;
import com.infusequest.quest.DailyQuestProgress;
import com.infusequest.quest.Quest;
import com.infusequest.quest.QuestLoader;
import com.infusequest.quest.QuestType;
import com.infusequest.quest.daily.DailyQuestManager;
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



        /*
         * No player killed the entity
         */
        if (player == null) {

            return;

        }





        EntityType killedEntity =
                event.getEntity()
                        .getType();




        DailyQuestManager manager =
                plugin.getDailyQuestManager();



        DailyQuestProgress progress =
                plugin.getDailyQuestProgress();






        for(PlayerDailyQuest dailyQuest :
                manager.getQuests(player)) {



            Quest quest =
        plugin.getQuestLoader()
              .getQuest(
                    dailyQuest.getQuestId()
              );



            if(quest == null) {

                continue;

            }




            /*
             * Check quest type
             */
            if(quest.getType()
                    != QuestType.KILL_ENTITY) {


                continue;

            }





            /*
             * Check entity target
             */
            if(!quest.getTargetName()
                    .equalsIgnoreCase(
                            killedEntity.name()
                    )) {


                continue;

            }






            /*
             * Add +1 kill progress
             */
            progress.addProgress(

                    player.getUniqueId(),

                    quest,

                    1

            );



        }


    }


}