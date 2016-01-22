package com.hackathon.cheherlock.interfaces;

import com.hackathon.cheherlock.interfaces.SportusBusinessObject;

import java.util.ArrayList;

/**
 * Created by Ravinder Nath Kamra on 8/1/2015.
 */
public interface ParseJSONtoSBO {
    public ArrayList<? extends SportusBusinessObject> parseJSON(String jsonContent);
}

