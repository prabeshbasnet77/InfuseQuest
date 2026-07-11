package com.infusequest;


import com.infusequest.database.Database;
import com.infusequest.config.ConfigManager;

import com.infusequest.quest.QuestManager;

import com.infusequest.listener.EntityKillListener;
import com.infusequest.listener.BlockBreakListener;
import com.infusequest.listener.PlayerJoinListener;

import com.infusequest.gui.GUIListener;

import com.infusequest.command.QuestCommand;
import com.infusequest.command.PowerCommand;

import com.infusequest.power.PowerManager;


import org.bukkit.plugin.java.JavaPlugin;



public class InfuseQuest extends JavaPlugin {



    private static InfuseQuest instance;


    private Database database;


    private ConfigManager configManager;


    private QuestManager questManager;


    private PowerManager powerManager;





    @Override
    public void onEnable(){



        instance = this;



        saveDefaultConfig();





        configManager =
                new ConfigManager(this);





        database =
                new Database(this);



        database.connect();





        questManager =
                new QuestManager(this);





        powerManager =
                new PowerManager(this);







        getServer()
                .getPluginManager()
                .registerEvents(

                        new EntityKillListener(
                                questManager
                        ),

                        this

                );







        getServer()
                .getPluginManager()
                .registerEvents(

                        new BlockBreakListener(
                                questManager
                        ),

                        this

                );







        getServer()
                .getPluginManager()
                .registerEvents(

                        new PlayerJoinListener(
                                this
                        ),

                        this

                );







        getServer()
                .getPluginManager()
                .registerEvents(

                        new GUIListener(
                                this
                        ),

                        this

                );







        getCommand("quests")
                .setExecutor(
                        new QuestCommand()
                );





        getCommand("infusepower")
                .setExecutor(
                        new PowerCommand()
                );







        getLogger().info(
                "================================="
        );


        getLogger().info(
                " InfuseQuest Enabled Successfully "
        );


        getLogger().info(
                " Hooked with InfuseSMP "
        );


        getLogger().info(
                "=================================");



    }









    @Override
    public void onDisable(){



        if(database != null){


            database.close();


        }



        getLogger().info(
                "InfuseQuest Disabled!"
        );


    }









    public static InfuseQuest getInstance(){


        return instance;


    }









    public Database getDatabase(){


        return database;


    }









    public ConfigManager getConfigManager(){


        return configManager;


    }









    public QuestManager getQuestManager(){


        return questManager;


    }









    public PowerManager getPowerManager(){


        return powerManager;


    }



}