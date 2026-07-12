package com.infusequest;


import com.infusequest.database.Database;

import com.infusequest.config.ConfigManager;


import com.infusequest.quest.QuestManager;
import com.infusequest.quest.QuestLoader;


import com.infusequest.quest.daily.DailyQuestManager;
import com.infusequest.quest.DailyQuestProgress;



import com.infusequest.listener.EntityKillListener;
import com.infusequest.listener.BlockBreakListener;
import com.infusequest.listener.PlayerJoinListener;
import com.infusequest.listener.PowerActivationListener;



import com.infusequest.gui.GUIListener;



import com.infusequest.command.QuestCommand;
import com.infusequest.command.PowerCommand;
import com.infusequest.command.InfuseDebugCommand;



import com.infusequest.power.PowerManager;
import com.infusequest.power.PowerActivationManager;
import com.infusequest.power.AbilitySyncManager;



import com.infusequest.hook.InfuseHook;



import org.bukkit.plugin.java.JavaPlugin;





public class InfuseQuest extends JavaPlugin {





    private static InfuseQuest instance;



    private Database database;


    private ConfigManager configManager;


    private QuestManager questManager;


    private PowerManager powerManager;



    private QuestLoader questLoader;



    private DailyQuestManager dailyQuestManager;


    private DailyQuestProgress dailyQuestProgress;




    private PowerActivationManager activationManager;


    private AbilitySyncManager abilitySyncManager;



    private InfuseHook infuseHook;









    @Override

    public void onEnable(){



        instance = this;



        saveDefaultConfig();









        configManager =

                new ConfigManager(this);







        database =

                new Database(this);



        database.connect();








        /*
        Infuse Hook
        */


        infuseHook =

                new InfuseHook();





        if(
        getServer()
        .getPluginManager()
        .getPlugin("Infuse")
        != null
        ){


            getLogger().info(
                    "Infuse 2.4.3 Found!"
            );


        }else{


            getLogger().warning(
                    "Infuse not found!"
            );


        }









        questLoader =

                new QuestLoader(this);



        questLoader.load();









        questManager =

                new QuestManager(this);









        powerManager =

                new PowerManager(this);








        activationManager =

                new PowerActivationManager(this);








        abilitySyncManager =

                new AbilitySyncManager(this);









        dailyQuestManager =

                new DailyQuestManager(this);






        dailyQuestProgress =

                new DailyQuestProgress(this);









        /*
        LISTENERS
        */



        getServer()
        .getPluginManager()
        .registerEvents(

                new EntityKillListener(this),

                this

        );






        getServer()
        .getPluginManager()
        .registerEvents(

                new BlockBreakListener(this),

                this

        );






        getServer()
        .getPluginManager()
        .registerEvents(

                new PlayerJoinListener(this),

                this

        );







        getServer()
        .getPluginManager()
        .registerEvents(

                new GUIListener(this),

                this

        );







        getServer()
        .getPluginManager()
        .registerEvents(

                new PowerActivationListener(

                        activationManager,

                        abilitySyncManager

                ),

                this

        );









        /*
        COMMANDS
        */



        if(getCommand("quests") != null){

    getCommand("quests")
            .setExecutor(
                    new QuestCommand(this)
            );

}







        if(getCommand("infusepower") != null){


            getCommand("infusepower")
                    .setExecutor(

                            new PowerCommand(this)

                    );


        }








        if(getCommand("infusedebug") != null){


            getCommand("infusedebug")
                    .setExecutor(

                            new InfuseDebugCommand(
                                    infuseHook
                            )

                    );


        }









        getLogger().info(
                "================================="
        );


        getLogger().info(
                " InfuseQuest Enabled Successfully "
        );


        getLogger().info(
                " Infuse Hook Loaded "
        );


        getLogger().info(
                " Daily Quest System Loaded "
        );


        getLogger().info(
                "================================="
        );



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









    public PowerActivationManager getActivationManager(){


        return activationManager;


    }









    public DailyQuestManager getDailyQuestManager(){


        return dailyQuestManager;


    }









    public DailyQuestProgress getDailyQuestProgress(){


        return dailyQuestProgress;


    }









    public QuestLoader getQuestLoader(){


        return questLoader;


    }









    public InfuseHook getInfuseHook(){


        return infuseHook;


    }





}