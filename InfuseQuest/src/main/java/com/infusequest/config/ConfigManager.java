package com.infusequest.config;


import com.infusequest.InfuseQuest;

import org.bukkit.configuration.file.FileConfiguration;



public class ConfigManager {


    private final InfuseQuest plugin;



    public ConfigManager(
    InfuseQuest plugin
    ){

        this.plugin = plugin;

    }



    public FileConfiguration getConfig(){

        return plugin.getConfig();

    }



}