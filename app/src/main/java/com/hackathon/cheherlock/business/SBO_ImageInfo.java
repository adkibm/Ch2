package com.hackathon.cheherlock.business;

import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

/**
 * Created by Ravinder Nath Kamra on 1/21/2016.
 */
public class SBO_ImageInfo implements SportusBusinessObject {

    private String ageRange;
    private String name;
    private String gender;


    public String parseToJson(){
        return "";
    }

    public String getAgeRange()
    {
        return ageRange;
    }
    public void setAgeRange(String s_age)
    {
        ageRange = s_age;
    }
    public String getName(){
        return name;
    }
    public void setName(String s_name){
        name = s_name;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
