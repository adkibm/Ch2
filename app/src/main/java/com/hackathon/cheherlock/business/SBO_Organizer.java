package com.hackathon.cheherlock.business;

import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

/**
 * Created by Ravinder Nath Kamra on 9/19/2015.
 */
public class SBO_Organizer implements SportusBusinessObject {
    private int organizer_id;
    private String organizer_name;
    private String organizer_contact;
    private int organizer_fee;
    private float organizer_rating;

    public int getOrganizer_id(){return organizer_id;}
    public void setOrganizer_id(int id){organizer_id = id;}
    public void setOrganizer_rating(float rating){ organizer_rating = rating ;}
    public float getOrganizer_rating(){return organizer_rating;}
    public String getOrganizer_contact(){return organizer_contact;}
    public void setOrganizer_contact(String contact) {organizer_contact = contact;}
    public String getOrganizer_name(){ return organizer_name;}
    public void setOrganizer_name(String name) { organizer_name = name;}
    public int getOrganizer_fee() { return organizer_fee;}
    public void setOrganizer_fee(int fee){ organizer_fee = fee;}

    @Override
    public String parseToJson() {
        return null;
    }
    public String toString(){return "";}
}
