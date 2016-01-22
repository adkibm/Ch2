package com.hackathon.cheherlock.parsejson;

import com.hackathon.cheherlock.business.SBO_City;
import com.hackathon.cheherlock.business.SBO_Stadium;
import com.hackathon.cheherlock.interfaces.ParseJSONtoSBO;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ravinder Nath Kamra on 9/19/2015.
 */
public class ParseStadium  implements ParseJSONtoSBO {


    @Override
    public ArrayList<? extends SportusBusinessObject> parseJSON(String jsonContent) {
        JSONObject jsonResponse;
        ArrayList<SBO_Stadium> responseArray = new ArrayList<SBO_Stadium>();
        try{
            jsonResponse = new JSONObject(jsonContent);
            JSONArray jsonMainNode = jsonResponse.optJSONArray("posts");
            int lengthJsonArr = jsonMainNode.length();

            for(int i=0; i < lengthJsonArr; i++) {
                /****** Get Object for each JSON node.***********/
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i).getJSONObject("post");
                //JSONObject jsonChildNode = jsChildRoot.getJSONObject(0);
//{"ground_id":"1","ground_name":"Gaur City Cricket Ground","ground_contact":"9999999999","ground_address":"Gaur City 1, Noida Extension","ground_fee":"12000","ground_city":"1","ground_sport":"1"}

                SBO_Stadium stadium = new SBO_Stadium();

                /******* Fetch node values **********/
                String ground_id = jsonChildNode.optString("ground_id").toString();
                stadium.setGround_id(Integer.parseInt(ground_id));
                stadium.setGround_name(jsonChildNode.optString("ground_name").toString());
                stadium.setGround_contact(jsonChildNode.optString("ground_contact").toString());
                stadium.setGround_address(jsonChildNode.optString("ground_address").toString());
                stadium.setGround_fee(jsonChildNode.optInt("ground_fee"));
                stadium.setCity_id(jsonChildNode.optInt("city_id"));
                stadium.setSport_id(jsonChildNode.optInt("sport_id"));

                responseArray.add(stadium);

            }


        }
        catch(JSONException e)
        {
            System.out.println("Exception " + e);
        }

        return responseArray;
    }

}
