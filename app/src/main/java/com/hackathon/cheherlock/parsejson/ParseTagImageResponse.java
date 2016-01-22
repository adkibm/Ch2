package com.hackathon.cheherlock.parsejson;

import com.hackathon.cheherlock.business.SBO_ImageInfo;
import com.hackathon.cheherlock.interfaces.ParseJSONtoSBO;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ravinder Nath Kamra on 1/21/2016.
 */
public class ParseTagImageResponse  implements ParseJSONtoSBO{

    @Override
    public ArrayList<? extends SportusBusinessObject> parseJSON(String jsonContent)
    {
        JSONObject jsonResponse;
        ArrayList<SBO_ImageInfo> responseArray = new ArrayList<SBO_ImageInfo>();
        try {
            SBO_ImageInfo response = new SBO_ImageInfo();
            jsonResponse = new JSONObject(jsonContent);
            JSONArray array = jsonResponse.getJSONArray("imageFaces");
            if (array.length() > 0)
            {
                JSONObject info = (JSONObject) array.get(0);
                JSONObject ageObject = (JSONObject) info.getJSONObject("age");
                JSONObject genderObject = (JSONObject) info.getJSONObject("gender");
                JSONObject identityObject = (JSONObject)info.getJSONObject("identity");
                if (ageObject != null){
                    String agerange = ageObject.getString("ageRange");
                    response.setAgeRange(agerange);
                }
                if (genderObject != null)
                {
                    String gender = genderObject.getString("gender");
                    response.setGender(gender);
                }
                if (identityObject != null){
                    String name = identityObject.getString("name");
                    response.setName(name);
                }
                responseArray.add(response);
            }

        }
        catch(Exception e)
        {

        }
        return responseArray;
    }
}
