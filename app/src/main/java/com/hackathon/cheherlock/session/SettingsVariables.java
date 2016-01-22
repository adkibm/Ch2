package com.hackathon.cheherlock.session;

import com.hackathon.cheherlock.business.SBO_City;
import com.hackathon.cheherlock.business.SBO_Sport;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ravinder Nath Kamra on 9/15/2015.
 */
public class SettingsVariables {

    private static SettingsVariables _instance;
    private SBO_City cityForSession;
    private SBO_Sport sportForSession;

    private Map<String,SBO_City> cityMap = new HashMap<String,SBO_City>();
    private Map<String,SBO_Sport> sportMap = new HashMap<String,SBO_Sport>();

    //Getter Setters

    public void setCityMap(Map<String,SBO_City> list)
    {
        cityMap = list;
    }

    public void setCityMap(List<? extends SportusBusinessObject> cityList)
    {
        for (int i = 0 ; i < cityList.size();i++)
        {
            SBO_City city = (SBO_City)cityList.get(i);
            cityMap.put(city.getName(),city);
        }
    }
    public Map<String,SBO_City> getCityMap()
    {
        return cityMap;
    }
    public void setSportMap(Map<String,SBO_Sport> list)
    {
        sportMap = list;
    }
    public void setSportMap(List<? extends SportusBusinessObject> sportList)
    {
        for (int i = 0 ; i < sportList.size();i++)
        {
            SBO_Sport sport = (SBO_Sport)sportList.get(i);
            sportMap.put(sport.getName(),sport);
        }
    }
    public Map<String,SBO_Sport> getSportMap()
    {
        return sportMap;
    }

    public SBO_City getCityForSession ()
    {
        return cityForSession;
    }
    public void setCityForSession(SBO_City city)
    {
        cityForSession = city;
    }
    public SBO_Sport getSportForSession()
    {
        return sportForSession ;
    }
    public void setSportForSession(SBO_Sport sport)
    {
        sportForSession = sport;
    }

    //Private Constructor
    private SettingsVariables()
    {

    }

   //Instance creation method

    public static SettingsVariables GetSettingVariables()
    {
        if (_instance == null)
            _instance = new SettingsVariables();
        return _instance;
    }

   
}
