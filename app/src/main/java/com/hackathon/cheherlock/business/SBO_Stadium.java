package com.hackathon.cheherlock.business;

import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

/**
 * Created by Ravinder Nath Kamra on 9/19/2015.
 */
public class SBO_Stadium implements SportusBusinessObject {
    private int ground_id;
    private String ground_name;
    private String ground_contact;
    private String ground_address;
    private int ground_fee;
    private int city_id;
    private int sport_id;

    public int getSport_id(){return sport_id;}
    public void setSport_id(int id){sport_id = id;}
    public void setCity_id(int id){ city_id = id ;}
    public int getCity_id(){return city_id;}
    public void setGround_fee(int fee){ ground_fee = fee;}
    public int getGround_fee(){return ground_fee;}
    public void setGround_address(String address){ground_address = address;}
    public String getGround_address (){return ground_address;}
    public String getGround_contact(){return ground_contact;}
    public void setGround_contact(String contact) {ground_contact = contact;}
    public String getGround_name(){ return ground_name;}
    public void setGround_name(String name) { ground_name = name;}
    public int getGround_id() { return ground_id;}
    public void setGround_id(int id){ ground_id = id;}

    @Override
    public String parseToJson() {
        return null;
    }
    public String toString(){return "";}
}
//{"ground_id":"1","ground_name":"Gaur City Cricket Ground","ground_contact":"9999999999","ground_address":"Gaur City 1, Noida Extension","ground_fee":"12000","ground_city":"1","ground_sport":"1"}
