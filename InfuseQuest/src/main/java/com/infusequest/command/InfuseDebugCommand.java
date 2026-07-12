package com.infusequest.command;



import com.infusequest.hook.InfuseHook;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;




public class InfuseDebugCommand implements CommandExecutor {



    private final InfuseHook hook;




    public InfuseDebugCommand(

            InfuseHook hook

    ){

        this.hook = hook;

    }








    @Override
    public boolean onCommand(

            CommandSender sender,

            Command command,

            String label,

            String[] args

    ){



        hook.debugMethods();



        sender.sendMessage(
        "§aInfuse DataManager scan completed. Check console."
        );



        return true;


    }



}