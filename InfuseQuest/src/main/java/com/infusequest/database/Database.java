package com.infusequest.database;


import com.infusequest.InfuseQuest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.UUID;



public class Database {


    private final InfuseQuest plugin;


    private Connection connection;





    public Database(InfuseQuest plugin) {

        this.plugin = plugin;

    }








    public void connect() {


        try {


            Class.forName(
                    "org.sqlite.JDBC"
            );



            connection =
                    DriverManager.getConnection(

                    "jdbc:sqlite:"
                    +
                    plugin.getDataFolder()
                    +
                    "/data.db"

                    );



            createTables();



        } catch(Exception e) {


            e.printStackTrace();


        }


    }









    private void createTables() {



        try(Statement statement =
                    connection.createStatement()) {





            /*
            PLAYER DATA
            */


            statement.execute("""
            CREATE TABLE IF NOT EXISTS players(

                uuid TEXT PRIMARY KEY,

                speed INTEGER DEFAULT 1,

                strength INTEGER DEFAULT 1,

                haste INTEGER DEFAULT 1,

                heart INTEGER DEFAULT 1,

                fire INTEGER DEFAULT 1,

                frost INTEGER DEFAULT 1,

                essence INTEGER DEFAULT 0

            )
            """);









            /*
            INFUSE POWER DATA
            */


            statement.execute("""
            CREATE TABLE IF NOT EXISTS player_powers(

                uuid TEXT NOT NULL,

                power TEXT NOT NULL,

                level INTEGER DEFAULT 1,

                owned INTEGER DEFAULT 0,

                PRIMARY KEY(uuid,power)

            )
            """);









            /*
            OLD QUEST SYSTEM
            */


            statement.execute("""
            CREATE TABLE IF NOT EXISTS quests(

                uuid TEXT,

                quest TEXT,

                progress INTEGER DEFAULT 0,

                completed INTEGER DEFAULT 0

            )
            """);









            /*
            DAILY QUEST SYSTEM

            24 hour refresh
            */


            statement.execute("""
            CREATE TABLE IF NOT EXISTS daily_quests(

                uuid TEXT NOT NULL,

                quest_id TEXT NOT NULL,

                progress INTEGER DEFAULT 0,

                claimed INTEGER DEFAULT 0,

                created_time LONG NOT NULL,

                PRIMARY KEY(uuid,quest_id)

            )
            """);





        }
        catch(SQLException e){


            e.printStackTrace();


        }



    }









    public Connection getConnection(){


        return connection;


    }









    /*
    ==========================
    ESSENCE SYSTEM
    ==========================
    */





    public int getEssence(UUID uuid){



        try{



            PreparedStatement ps =
                    connection.prepareStatement(

                    """
                    SELECT essence
                    FROM players
                    WHERE uuid=?
                    """

                    );



            ps.setString(

                    1,

                    uuid.toString()

            );




            ResultSet rs =
                    ps.executeQuery();





            if(rs.next()){


                return rs.getInt(
                        "essence"
                );


            }





        }
        catch(Exception e){


            e.printStackTrace();


        }




        return 0;


    }









    public void removeEssence(

            UUID uuid,

            int amount

    ){



        try{



            PreparedStatement ps =
                    connection.prepareStatement(

                    """
                    UPDATE players

                    SET essence = essence - ?

                    WHERE uuid=?

                    """

                    );





            ps.setInt(

                    1,

                    amount

            );




            ps.setString(

                    2,

                    uuid.toString()

            );





            ps.executeUpdate();





        }
        catch(Exception e){


            e.printStackTrace();


        }


    }









    public void addEssence(

            UUID uuid,

            int amount

    ){



        try{



            PreparedStatement ps =
                    connection.prepareStatement(

                    """
                    UPDATE players

                    SET essence = essence + ?

                    WHERE uuid=?

                    """

                    );





            ps.setInt(

                    1,

                    amount

            );




            ps.setString(

                    2,

                    uuid.toString()

            );





            ps.executeUpdate();





        }
        catch(Exception e){


            e.printStackTrace();


        }


    }









    public void close(){



        try{



            if(connection != null){


                connection.close();


            }



        }
        catch(SQLException e){


            e.printStackTrace();


        }



    }



}