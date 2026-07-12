package com.infusequest.power;


public class PlayerPower {



    private PowerType type;


    private int level;


    private boolean owned;






    public PlayerPower(

            PowerType type,

            int level,

            boolean owned

    ){


        this.type = type;

        this.level = level;

        this.owned = owned;


    }







    public PowerType getType(){

        return type;

    }







    public int getLevel(){

        return level;

    }







    public void setLevel(int level){

        this.level = level;

    }








    public boolean isOwned(){

        return owned;

    }







    public void setOwned(boolean owned){

        this.owned = owned;

    }



}