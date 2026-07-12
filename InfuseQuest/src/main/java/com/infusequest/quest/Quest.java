package com.infusequest.quest;


public class Quest {


    private final String id;
    private final String name;
    private final QuestType type;
    private final String target;
    private final int amount;
    private final int essence;
    private final QuestDifficulty difficulty;




    public Quest(
            String id,
            String name,
            QuestType type,
            String target,
            int amount,
            int essence,
            QuestDifficulty difficulty
    ){

        this.id = id;
        this.name = name;
        this.type = type;
        this.target = target;
        this.amount = amount;
        this.essence = essence;
        this.difficulty = difficulty;

    }





    public Quest(
            String id,
            String name,
            QuestType type,
            String target,
            int amount,
            int essence
    ){

        this(
                id,
                name,
                type,
                target,
                amount,
                essence,
                QuestDifficulty.EASY
        );

    }





    public String getId(){

        return id;

    }


    public String getName(){

        return name;

    }


    public QuestType getType(){

        return type;

    }


    public String getTarget(){

        return target;

    }


    public String getTargetName(){

        return target;

    }


    public int getAmount(){

        return amount;

    }


    public int getGoal(){

        return amount;

    }


    public int getReward(){

        return essence;

    }


    public int getEssence(){

        return essence;

    }


    public QuestDifficulty getDifficulty(){

        return difficulty;

    }


}