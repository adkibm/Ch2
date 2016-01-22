package com.hackathon.cheherlock.parsejson;

import com.hackathon.cheherlock.business.SBO_Organizer;
import com.hackathon.cheherlock.interfaces.ParseJSONtoSBO;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ravinder Nath Kamra on 9/20/2015.
 */
public class PraseOrganizer implements ParseJSONtoSBO {


    @Override
    public ArrayList<? extends SportusBusinessObject> parseJSON(String jsonContent) {
        JSONObject jsonResponse;
        ArrayList<SBO_Organizer> responseArray = new ArrayList<SBO_Organizer>();
        try{
            jsonResponse = new JSONObject(jsonContent);
            JSONArray jsonMainNode = jsonResponse.optJSONArray("posts");
            int lengthJsonArr = jsonMainNode.length();

            for(int i=0; i < lengthJsonArr; i++) {
                /****** Get Object for each JSON node.***********/
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i).getJSONObject("post");
                //JSONObject jsonChildNode = jsChildRoot.getJSONObject(0);

                SBO_Organizer organizer = new SBO_Organizer();

                /******* Fetch node values **********/
                organizer.setOrganizer_id(jsonChildNode.optInt("organizer_id"));
                organizer.setOrganizer_name(jsonChildNode.optString("organizer_name").toString());
                organizer.setOrganizer_contact(jsonChildNode.optString("organizer_contact").toString());
                organizer.setOrganizer_fee(jsonChildNode.optInt("organizer_fee"));
                organizer.setOrganizer_rating(Float.parseFloat(jsonChildNode.optString("organizer_rating")));

                responseArray.add(organizer);

            }


        }
        catch(JSONException e)
        {
            System.out.println("Exception " + e);
        }

        return responseArray;
    }

}

