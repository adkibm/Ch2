package com.hackathon.cheherlock.parsejson;

import com.hackathon.cheherlock.business.SBO_City;
import com.hackathon.cheherlock.interfaces.ParseJSONtoSBO;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ravinder Nath Kamra on 8/1/2015.
 */
public class ParseCity implements ParseJSONtoSBO{


    @Override
    public ArrayList<? extends SportusBusinessObject> parseJSON(String jsonContent) {
        JSONObject jsonResponse;
        ArrayList<SBO_City> responseArray = new ArrayList<SBO_City>();
        try{
            jsonResponse = new JSONObject(jsonContent);
            JSONArray jsonMainNode = jsonResponse.optJSONArray("posts");
            int lengthJsonArr = jsonMainNode.length();

            for(int i=0; i < lengthJsonArr; i++) {
                /****** Get Object for each JSON node.***********/
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i).getJSONObject("post");
                //JSONObject jsonChildNode = jsChildRoot.getJSONObject(0);

                SBO_City city = new SBO_City();

                /******* Fetch node values **********/
                 String cityIDString = jsonChildNode.optString("city_id").toString();
                 city.setID(Integer.parseInt(cityIDString));
                 city.setName(jsonChildNode.optString("city_name").toString());
                 responseArray.add(city);

              }


            }
        catch(JSONException e)
        {
           System.out.println("Exception " + e);
        }

        return responseArray;
    }

}
