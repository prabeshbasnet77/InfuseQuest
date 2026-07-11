package com.infusequest.database;


import com.infusequest.InfuseQuest;

import java.sql.*;



public class Database {


    private final InfuseQuest plugin;


    private Connection connection;



    public Database(InfuseQuest plugin){

        this.plugin = plugin;

    }





    public void connect(){


        try{


            Class.forName(
            "org.sqlite.JDBC"
            );


            connection =
            DriverManager.getConnection(

            "jdbc:sqlite:"
            + plugin.getDataFolder()
            + "/data.db"

            );



            createTables();



        }catch(Exception e){

            e.printStackTrace();

        }


    }





    private void createTables(){


        try{


            Statement statement =
            connection.createStatement();



            statement.execute(

            """
            CREATE TABLE IF NOT EXISTS players(

            uuid TEXT PRIMARY KEY,

            speed INTEGER DEFAULT 1,

            strength INTEGER DEFAULT 1,

            haste INTEGER DEFAULT 1,

            heart INTEGER DEFAULT 1,

            essence INTEGER DEFAULT 0

            )
            """

            );



            statement.execute(

            """
            CREATE TABLE IF NOT EXISTS quests(

            uuid TEXT,

            quest TEXT,

            progress INTEGER DEFAULT 0,

            completed INTEGER DEFAULT 0

            )
            """

            );




        }catch(SQLException e){

            e.printStackTrace();

        }


    }






    public Connection getConnection(){

        return connection;

    }






    public void close(){


        try{


            if(connection != null)

                connection.close();



        }catch(SQLException e){

            e.printStackTrace();

        }


    }



}