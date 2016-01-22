package com.hackathon.cheherlock.business;

import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

/**
 * Created by Ravinder Nath Kamra on 8/1/2015.
 */
public class SBO_City implements SportusBusinessObject {

    private int city_id=-1;
    private String city_name;

    {
        city_name = "";
    }

    public void setID(int value)
    {
       city_id = value;
    }
    public int getID()
    {
       return (city_id);
    }
    public void setName(String value)
    {
        city_name = value;
    }
    public String getName()
    {
        return (city_name);
    }
    @Override
    public String parseToJson() {
        return null;
    }
    public String toString(){return city_name;}


}
