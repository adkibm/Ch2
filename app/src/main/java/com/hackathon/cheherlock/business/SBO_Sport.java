package com.hackathon.cheherlock.business;

import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

/**
 * Created by Ravinder Nath Kamra on 9/5/2015.
 */
public class SBO_Sport implements SportusBusinessObject{
    private String name;
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    @Override
    public String parseToJson() {
        return null;
    }
    public String toString(){return name;}
}
