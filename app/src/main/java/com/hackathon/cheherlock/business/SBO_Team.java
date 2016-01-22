package com.hackathon.cheherlock.business;

import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

/**
 * Created by Ravinder Nath Kamra on 9/19/2015.
 */
//{"post":{"team_id":"1","team_name":"SportyUs","team_sport":"1","team_city":"1","team_contact":"9090909090","team_company":"0","team_captain":"Aditya Kamra"}}
public class SBO_Team implements SportusBusinessObject {
    private int team_id;
    private String team_name;
    private String team_contact;
    private String team_captain;
    private int team_company;
    private int team_city;
    private int team_sport;

    public int getTeam_id(){return team_id;}
    public void setTeam_id(int id){team_id = id;}
    public void setCity_id(int id){ team_city = id ;}
    public int getCity_id(){return team_city;}
    public void setTeam_company(int company){ team_company = company;}
    public int getTeam_company(){return team_company;}
    public void setTeam_captain(String name){team_captain = name;}
    public String getTeam_captain (){return team_captain;}
    public String getTeam_contact(){return team_contact;}
    public void setTeam_contact(String contact) {team_contact = contact;}
    public String getTeam_name(){ return team_name;}
    public void setTeam_name(String name) { team_name = name;}
    public int getTeam_sport() { return team_sport;}
    public void setTeam_sport(int id){ team_sport = id;}

    @Override
    public String parseToJson() {
        return null;
    }
    public String toString(){return "";}
}
