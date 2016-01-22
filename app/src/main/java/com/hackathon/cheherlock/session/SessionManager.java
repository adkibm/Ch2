package com.hackathon.cheherlock.session;

/**
 * Created by Ravinder Nath Kamra on 9/5/2015.
 */
import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.hackathon.cheherlock.activity.LoginActivity;
import com.hackathon.cheherlock.business.SBO_City;
import com.hackathon.cheherlock.business.SBO_Sport;

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "CheherlockPref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";
    public static final String KEY_CITY = "city";
    public static final String KEY_SPORT = "sport";
    public static final String IS_SECOND_VISIT = "visit";


    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     * */
    public void createLoginSession(String name, String email){
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, name);

        // Storing email in pref
        editor.putString(KEY_EMAIL, email);

        // commit changes
        editor.commit();
    }

    public void setCitySportPref(String city, String sport){

        // Storing name in pref
        editor.putString(KEY_CITY, city);

        // Storing email in pref
        editor.putString(KEY_SPORT, sport);

        // commit changes
        editor.commit();

    }

    public void setCityIdPref(String city,int id)
    {
        editor.putInt(city, id);
        editor.commit();
    }

    public void setIsSecondVisit()
    {
        editor.putBoolean(IS_SECOND_VISIT, true);
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     * */
    public SBO_City getCityPref(){
        // Check login status
        String city = pref.getString(KEY_CITY,null);
        SBO_City citydetails = new SBO_City();
        if (city!= null)
        {
            citydetails.setName(city);
            int city_id = pref.getInt(city,-1);
            citydetails.setID(city_id);
        }
        return citydetails;
    }

    public SBO_Sport getSportPref (){
        String sport = pref.getString(KEY_SPORT,null);
        SBO_Sport sportdetail = new SBO_Sport();
        if (sport!=null)
        {
            sportdetail.setName(sport);
            int sport_id = pref.getInt(sport,-1);
            sportdetail.setId(sport_id);
        }
        return sportdetail;
    }



    /**
     * Get stored session data
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        // user name
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));

        // user email id
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        // return user
        return user;
    }

    /**
     * Clear session details
     * */
    public void logoutUser(){
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();

        // After logout redirect user to Loing Activity
        Intent i = new Intent(_context, LoginActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Activity
        _context.startActivity(i);
    }

    /**
     * Quick check for login
     * **/
    // Get Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public boolean getIsSecondVisit()
    {
        return pref.getBoolean(IS_SECOND_VISIT, false);
    }

}
