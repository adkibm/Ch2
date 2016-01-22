package com.hackathon.cheherlock.business;

import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

/**
 * Created by Ravinder Nath Kamra on 9/19/2015.
 */
public class SBO_Tournament implements SportusBusinessObject {
    private int tournament_id;
    private String tournament_name;
    private int tournament_sport;
    private int tournament_city;
    private String tournament_contact;
    private int tournament_fee;
    private int no_of_teams;
    private int tournament_organizer;

    public int getTournament_id(){return tournament_id;}
    public void setTournament_id(int id){tournament_id = id;}
    public String getTournament_name(){return tournament_name;}
    public void setTournament_name(String name){tournament_name = name;}
    public int getTournament_sport(){return tournament_sport;}
    public void setTournament_sport(int sport){tournament_sport = sport;}
    public int getTournament_city(){return tournament_city;}
    public void setTournament_city(int city){tournament_city = city;}
    public String getTournament_contact(){return tournament_contact;}
    public void setTournament_contact(String contact){tournament_contact = contact;}
    public int getTournament_fee(){return tournament_fee;}
    public void setTournament_fee(int fee){tournament_fee = fee;}
    public int getNo_of_teams(){return no_of_teams;}
    public void setNo_of_teams(int no_of_teams){this.no_of_teams = no_of_teams;}
    public int getTournament_organizer(){return tournament_organizer;}
    public void setTournament_organizer(int organizer){tournament_organizer = organizer;}

    @Override
    public String parseToJson() {
        return null;
    }
    public String toString(){return "";}
}

