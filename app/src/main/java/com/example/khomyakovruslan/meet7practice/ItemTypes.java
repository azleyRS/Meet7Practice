package com.example.khomyakovruslan.meet7practice;

public enum ItemTypes {
    ITEM1(1),
    ITEM2(2),
    ITEM3(3);

    int type;

    ItemTypes(int type){
        this.type = type;
    }

    public int getType(){
        return type;
    }

}
