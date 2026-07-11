package com.infusequest.listener;


import com.infusequest.quest.QuestManager;


import org.bukkit.event.Listener;

import org.bukkit.event.EventHandler;

import org.bukkit.event.entity.EntityDeathEvent;

import org.bukkit.entity.Player;



public class EntityKillListener implements Listener {



private QuestManager manager;



public EntityKillListener(
QuestManager manager
){

this.manager=manager;

}





@EventHandler

public void onKill(
EntityDeathEvent event
){


Player player =
event.getEntity()
.getKiller();



if(player==null)
return;



String mob =
event.getEntity()
.getType()
.name();



manager.addProgress(

player,

"zombie_hunter",

1

);



}


}