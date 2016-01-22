package com.hackathon.cheherlock.parsejson;

import com.hackathon.cheherlock.business.SBO_Stadium;
import com.hackathon.cheherlock.business.SBO_Tournament;
import com.hackathon.cheherlock.interfaces.ParseJSONtoSBO;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ravinder Nath Kamra on 9/22/2015.
 */
public class ParseTournament  implements ParseJSONtoSBO {


    @Override
    public ArrayList<? extends SportusBusinessObject> parseJSON(String jsonContent) {
        JSONObject jsonResponse;
        ArrayList<SBO_Tournament> responseArray = new ArrayList<SBO_Tournament>();
        try{
            jsonResponse = new JSONObject(jsonContent);
            JSONArray jsonMainNode = jsonResponse.optJSONArray("posts");
            int lengthJsonArr = jsonMainNode.length();

            for(int i=0; i < lengthJsonArr; i++) {
                /****** Get Object for each JSON node.***********/
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i).getJSONObject("post");
                //JSONObject jsonChildNode = jsChildRoot.getJSONObject(0);
//{"ground_id":"1","ground_name":"Gaur City Cricket Ground","ground_contact":"9999999999","ground_address":"Gaur City 1, Noida Extension","ground_fee":"12000","ground_city":"1","ground_sport":"1"}

                SBO_Tournament tournament = new SBO_Tournament();

                /******* Fetch node values **********/
               // String ground_id = jsonChildNode.optString("ground_id").toString();
                tournament.setTournament_id(jsonChildNode.optInt("tournament_id"));
                tournament.setTournament_name(jsonChildNode.optString("tournament_name").toString());
                tournament.setTournament_organizer(jsonChildNode.optInt("tournament_organizer"));
                tournament.setNo_of_teams(jsonChildNode.optInt("no_of_teams"));
                tournament.setTournament_fee(jsonChildNode.optInt("tournament_fee"));
                tournament.setTournament_city(jsonChildNode.optInt("tournament_city"));
                tournament.setTournament_contact(jsonChildNode.optString("tournament_contact").toString());
                tournament.setTournament_sport(jsonChildNode.optInt("tournament_sport"));

                responseArray.add(tournament);

            }


        }
        catch(JSONException e)
        {
            System.out.println("Exception " + e);
        }

        return responseArray;
    }

}

