package com.infusequest.database;


import com.infusequest.InfuseQuest;
import com.infusequest.quest.daily.PlayerDailyQuest;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class DailyQuestRepository {


    private final InfuseQuest plugin;


    public DailyQuestRepository(
            InfuseQuest plugin
    ){

        this.plugin = plugin;

    }




    public List<PlayerDailyQuest> load(
            UUID uuid
    ){


        List<PlayerDailyQuest> quests =
                new ArrayList<>();


        try{


            PreparedStatement ps =
                    plugin.getDatabase()
                    .getConnection()
                    .prepareStatement(

                    """
                    SELECT *
                    FROM daily_quests
                    WHERE uuid=?
                    """

                    );


            ps.setString(
                    1,
                    uuid.toString()
            );


            ResultSet rs =
                    ps.executeQuery();



            while(rs.next()){


                PlayerDailyQuest quest =
                        new PlayerDailyQuest(

                        rs.getString("quest_id")

                        );



                quest.setProgress(
                        rs.getInt("progress")
                );


                quest.setCompleted(
                        rs.getBoolean("completed")
                );



                quests.add(quest);



            }



        }catch(Exception e){

            e.printStackTrace();

        }



        return quests;


    }






    public void save(
            UUID uuid,
            PlayerDailyQuest quest
    ){


        try{


            PreparedStatement ps =
                    plugin.getDatabase()
                    .getConnection()
                    .prepareStatement(

                    """
                    INSERT INTO daily_quests
                    (
                    uuid,
                    quest_id,
                    progress,
                    completed,
                    created
                    )

                    VALUES(?,?,?,?,?)

                    """

                    );



            ps.setString(
                    1,
                    uuid.toString()
            );


            ps.setString(
                    2,
                    quest.getQuestId()
            );


            ps.setInt(
                    3,
                    quest.getProgress()
            );


            ps.setBoolean(
                    4,
                    quest.isCompleted()
            );


            ps.setLong(
                    5,
                    System.currentTimeMillis()
            );


            ps.executeUpdate();



        }catch(Exception e){

            e.printStackTrace();

        }



    }







    public boolean needsReset(
            UUID uuid
    ){



        try{


            PreparedStatement ps =
                    plugin.getDatabase()
                    .getConnection()
                    .prepareStatement(

                    """
                    SELECT created
                    FROM daily_quests
                    WHERE uuid=?
                    LIMIT 1
                    """

                    );



            ps.setString(
                    1,
                    uuid.toString()
            );



            ResultSet rs =
                    ps.executeQuery();



            if(rs.next()){


                long created =
                        rs.getLong("created");



                long now =
                        System.currentTimeMillis();



                long difference =
                        now-created;



                return difference >=
                        86400000L;


            }



        }catch(Exception e){

            e.printStackTrace();

        }



        return true;


    }








    public void reset(
            UUID uuid
    ){


        try{


            PreparedStatement ps =
                    plugin.getDatabase()
                    .getConnection()
                    .prepareStatement(

                    """
                    DELETE FROM daily_quests
                    WHERE uuid=?
                    """

                    );


            ps.setString(
                    1,
                    uuid.toString()
            );


            ps.executeUpdate();



        }catch(Exception e){

            e.printStackTrace();

        }



    }






    public void update(
            UUID uuid,
            PlayerDailyQuest quest
    ){


        try{


            PreparedStatement ps =
                    plugin.getDatabase()
                    .getConnection()
                    .prepareStatement(

                    """
                    UPDATE daily_quests

                    SET progress=?,
                    completed=?

                    WHERE uuid=?
                    AND quest_id=?

                    """

                    );



            ps.setInt(
                    1,
                    quest.getProgress()
            );


            ps.setBoolean(
                    2,
                    quest.isCompleted()
            );


            ps.setString(
                    3,
                    uuid.toString()
            );


            ps.setString(
                    4,
                    quest.getQuestId()
            );



            ps.executeUpdate();



        }catch(Exception e){

            e.printStackTrace();

        }


    }



}