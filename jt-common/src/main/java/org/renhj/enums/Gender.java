package org.renhj.enums;

public enum Gender {
    MALE("男"),
    FEMALE("女");

    private String gender;
    Gender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }
}
