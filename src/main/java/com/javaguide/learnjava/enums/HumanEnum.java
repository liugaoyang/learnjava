package com.javaguide.learnjava.enums;

public enum HumanEnum {
    MAN("男"),WOMEN("女");
    String name;
    private HumanEnum(String name){
        this.name = name;
    }
    boolean isaMan(){
        if(this.name.equals("男")){
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
