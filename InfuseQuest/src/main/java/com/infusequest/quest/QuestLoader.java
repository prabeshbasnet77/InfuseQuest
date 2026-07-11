package com.infusequest.quest;



import com.infusequest.InfuseQuest;


import org.bukkit.configuration.file.FileConfiguration;


import java.util.*;



public class QuestLoader {



private InfuseQuest plugin;



private List<Quest> quests =
new ArrayList<>();





public QuestLoader(
InfuseQuest plugin
){

this.plugin=plugin;


}




public void load(){


FileConfiguration config =
plugin.getConfig();



quests.clear();



quests.add(

new Quest(

"zombie",

"§cZombie Hunter",

QuestType.KILL_ENTITY,

"ZOMBIE",

25,

2

)

);



quests.add(

new Quest(

"miner",

"§6Master Miner",

QuestType.BREAK_BLOCK,

"STONE",

128,

2

)

);



}





public List<Quest> getQuests(){

return quests;

}




}