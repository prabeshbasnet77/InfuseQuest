package com.infusequest.quest;


public class Quest {


private String id;

private String name;

private QuestType type;

private String target;

private int amount;

private int reward;




public Quest(

String id,

String name,

QuestType type,

String target,

int amount,

int reward

){


this.id=id;

this.name=name;

this.type=type;

this.target=target;

this.amount=amount;

this.reward=reward;


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


public int getAmount(){

return amount;

}


public int getReward(){

return reward;

}



}