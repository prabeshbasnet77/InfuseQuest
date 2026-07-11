package com.infusequest.power;


import com.infusequest.InfuseQuest;

import org.bukkit.entity.Player;


import java.sql.PreparedStatement;



public class PowerManager {



private InfuseQuest plugin;



public PowerManager(
InfuseQuest plugin
){

this.plugin=plugin;

}




public boolean upgrade(

Player player,

PowerType power

){



try{


PreparedStatement ps =
plugin.getDatabase()
.getConnection()
.prepareStatement(

"""

SELECT essence FROM players

WHERE uuid=?

"""

);



ps.setString(

1,

player.getUniqueId()
.toString()

);



var result =
ps.executeQuery();



if(result.next()){


int essence =
result.getInt("essence");



if(essence < 5){

player.sendMessage(
"§cNot enough Essence!"
);

return false;

}




PreparedStatement remove =
plugin.getDatabase()
.getConnection()
.prepareStatement(

"""

UPDATE players

SET essence = essence - 5

WHERE uuid=?

"""

);



remove.setString(

1,

player.getUniqueId()
.toString()

);



remove.executeUpdate();





InfuseHook.upgrade(

player,

power,

2

);



return true;



}



}catch(Exception e){

e.printStackTrace();

}



return false;



}


}