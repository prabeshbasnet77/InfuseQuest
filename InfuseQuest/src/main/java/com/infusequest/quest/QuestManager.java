package com.infusequest.quest;


import com.infusequest.InfuseQuest;

import java.util.*;

import java.sql.*;



import org.bukkit.entity.Player;



public class QuestManager {


private final InfuseQuest plugin;



public QuestManager(
InfuseQuest plugin
){

this.plugin=plugin;

}





public void addProgress(
Player player,
String quest,
int amount
){


try{


PreparedStatement ps =
plugin.getDatabase()
.getConnection()
.prepareStatement(

"""
UPDATE quests

SET progress = progress + ?

WHERE uuid=? AND quest=?

"""

);



ps.setInt(1,amount);

ps.setString(
2,
player.getUniqueId().toString()
);


ps.setString(
3,
quest
);


ps.executeUpdate();




}catch(Exception e){

e.printStackTrace();

}


}






public void complete(
Player player,
Quest quest
){



player.sendMessage(

"§aQuest Completed: "

+quest.getName()

);



giveReward(
player,
quest.getReward()
);



}





private void giveReward(
Player player,
int amount
){


try{


PreparedStatement ps =
plugin.getDatabase()
.getConnection()
.prepareStatement(

"""
UPDATE players

SET essence = essence + ?

WHERE uuid=?

"""

);


ps.setInt(1,amount);


ps.setString(
2,
player.getUniqueId().toString()
);


ps.executeUpdate();



player.sendMessage(

"§b+"

+amount

+" Essence"

);



}catch(Exception e){

e.printStackTrace();

}



}



}