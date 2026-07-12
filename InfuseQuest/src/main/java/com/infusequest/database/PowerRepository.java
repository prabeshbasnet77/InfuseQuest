package com.infusequest.database;


import com.infusequest.InfuseQuest;
import com.infusequest.power.*;

import java.sql.*;
import java.util.UUID;



public class PowerRepository {



private final InfuseQuest plugin;



public PowerRepository(
        InfuseQuest plugin
){

    this.plugin = plugin;

}





public PlayerPower getPower(

        UUID uuid,

        PowerType type

){


try{


PreparedStatement ps =
plugin.getDatabase()
.getConnection()
.prepareStatement(

"""
SELECT *
FROM player_powers
WHERE uuid=? AND power=?
"""

);


ps.setString(
1,
uuid.toString()
);


ps.setString(
2,
type.name()
);



ResultSet rs =
ps.executeQuery();



if(rs.next()){


return new PlayerPower(

type,

rs.getInt("level"),

rs.getInt("owned")==1

);


}



}catch(Exception e){

e.printStackTrace();

}



return new PlayerPower(

type,

1,

false

);


}







public void save(

UUID uuid,

PlayerPower power

){


try{


PreparedStatement ps =
plugin.getDatabase()
.getConnection()
.prepareStatement(

"""
INSERT OR REPLACE INTO player_powers

(uuid,power,level,owned)

VALUES(?,?,?,?)

"""

);


ps.setString(
1,
uuid.toString()
);


ps.setString(
2,
power.getType().name()
);


ps.setInt(
3,
power.getLevel()
);


ps.setInt(
4,
power.isOwned()?1:0
);



ps.executeUpdate();



}catch(Exception e){

e.printStackTrace();

}



}


}