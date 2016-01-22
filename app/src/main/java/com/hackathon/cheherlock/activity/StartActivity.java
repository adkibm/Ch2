package com.hackathon.cheherlock.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hackathon.cheherlock.R;
import com.hackathon.cheherlock.activity.SearchFilterActivity;
import com.hackathon.cheherlock.activity.SignupActivity;
import com.hackathon.cheherlock.business.SBO_City;
import com.hackathon.cheherlock.business.SBO_Sport;
import com.hackathon.cheherlock.interfaces.IWebConnected;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;
import com.hackathon.cheherlock.network.WebCallerAPI;
import com.hackathon.cheherlock.parsejson.ParseCity;
import com.hackathon.cheherlock.parsejson.ParseLoginResponse;
import com.hackathon.cheherlock.session.SessionManager;
import com.hackathon.cheherlock.session.SettingsVariables;

import java.util.ArrayList;

/**
 * Created by Ravinder Nath Kamra on 9/5/2015.
 */
public class StartActivity extends AppCompatActivity implements IWebConnected {

    SessionManager session;
    ProgressDialog progressDialogref;
    volatile int async_counter = 0;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);
        /*
        final ProgressDialog progressDialog = new ProgressDialog(StartActivity.this,
                R.style.Base_Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading App Data...");
        progressDialog.show();
        progressDialogref = progressDialog;*/
        session = new SessionManager(getApplicationContext());


    }

    public void startActivity(View v)
    {
        Intent intent = new Intent(getApplicationContext(), com.hackathon.cheherlock.activity.MainActivity.class);
        startActivity(intent);
    }

    public void firstVisitAction()
    {
        session.setIsSecondVisit();
        Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
        startActivity(intent);
    }

    public void secondVisitAction()
    {
        SBO_Sport sport = session.getSportPref();
        SBO_City city = session.getCityPref();
        if ((sport.getId() == -1) || (city.getID()== -1))
        {
            //Toast.makeText(getBaseContext(), "Call City and Sport View", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), SearchFilterActivity.class);
            startActivity(intent);
        }
        else
        {
            if (session.isLoggedIn())
               Toast.makeText(getBaseContext(), "Call Main View with Login", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(getBaseContext(), "Call Main View without login", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void setView(ArrayList<? extends SportusBusinessObject> sbo) {
        SettingsVariables sv = SettingsVariables.GetSettingVariables();
        if (sbo.get(0) instanceof SBO_City){
            sv.setCityMap(sbo);
            async_counter++;

        }
        else if (sbo.get(0) instanceof SBO_Sport){
            sv.setSportMap(sbo);
            async_counter++;
        }
        if (async_counter == 2)
        {
            session = new SessionManager(getApplicationContext());
            if (!session.getIsSecondVisit())
                firstVisitAction();
            else
                secondVisitAction();
        }

    }


}
