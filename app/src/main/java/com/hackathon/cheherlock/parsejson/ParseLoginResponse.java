package com.hackathon.cheherlock.parsejson;

import com.hackathon.cheherlock.business.SBO_AuthResponse;
import com.hackathon.cheherlock.business.SBO_User;
import com.hackathon.cheherlock.interfaces.ParseJSONtoSBO;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ravinder Nath Kamra on 8/30/2015.
 */
public class ParseLoginResponse implements ParseJSONtoSBO {
    @Override
    public ArrayList<? extends SportusBusinessObject> parseJSON(String jsonContent) {
        JSONObject jsonResponse;
        ArrayList<SBO_AuthResponse> responseArray = new ArrayList<SBO_AuthResponse>();
        try {
            SBO_AuthResponse response = new SBO_AuthResponse();
            jsonResponse = new JSONObject(jsonContent);
            response.setAction_type(jsonResponse.getString("tag"));
            boolean error = jsonResponse.getBoolean("error");
            response.setError(error);
            if (error)
               response.setError_msg(jsonResponse.getString("error_msg"));
            responseArray.add(response);
        }
        catch(Exception e)
        {

        }
        return responseArray;

    }
}
