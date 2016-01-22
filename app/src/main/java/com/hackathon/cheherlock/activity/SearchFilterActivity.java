package com.hackathon.cheherlock.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.cheherlock.R;
import com.hackathon.cheherlock.activity.*;
import com.hackathon.cheherlock.adapter.ExpandableListAdapter;
import com.hackathon.cheherlock.business.SBO_City;
import com.hackathon.cheherlock.business.SBO_ImageInfo;
import com.hackathon.cheherlock.business.SBO_Sport;
import com.hackathon.cheherlock.interfaces.IWebConnected;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;
import com.hackathon.cheherlock.network.WebCallerAPI;
import com.hackathon.cheherlock.parsejson.ParseTagImageResponse;
import com.hackathon.cheherlock.session.SessionManager;
import com.hackathon.cheherlock.session.SettingsVariables;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Ravinder Nath Kamra on 9/6/2015.
 */
public class SearchFilterActivity extends AppCompatActivity implements IWebConnected{


    private Toolbar mToolbar;
    private String stringURL = "";
    ProgressDialog progressDialogref;
    private String givenName="";
    private TextView failPassText;
    private TextView givenNameText;
    private TextView actualNameText;




    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_filter_activity);
        mToolbar = (Toolbar) findViewById(R.id.toolbarfilteractivity);
        // get the listview
        //expListView = (ExpandableListView) findViewById(R.id.lvExp);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        // preparing list data
        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            stringURL = extras.getString("url");
            givenName = extras.getString("given_name");
        }
        failPassText = (TextView) findViewById(R.id.fail_pass_text);
        givenNameText = (TextView) findViewById(R.id.name_provided_text);
        actualNameText = (TextView) findViewById(R.id.name_actual_text);

        final ProgressDialog progressDialog = new ProgressDialog(SearchFilterActivity.this,
                R.style.Base_Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Loading Results...");
        progressDialog.show();
        progressDialogref = progressDialog;


        WebCallerAPI webCall = new WebCallerAPI();
        webCall.setConnectedActivity(this);
        webCall.setParseStrategy(new ParseTagImageResponse());
        webCall.setURT(stringURL);
        webCall.call();


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_with_next_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_next) {
            ShowMainActivity();
        }


        return super.onOptionsItemSelected(item);
    }
    public void ShowMainActivity()
    {
        Intent intent = new Intent(getApplicationContext(), com.hackathon.cheherlock.activity.MainActivity.class);
        startActivity(intent);
    }
    /*
     * Preparing the list data
     */

    public int GetDipsFromPixel(float pixels)
    {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }

    @Override
    public void setView(ArrayList<? extends SportusBusinessObject> sbo) {
        SBO_ImageInfo info = (SBO_ImageInfo)sbo.get(0);
        progressDialogref.dismiss();
        if (info.getName().toLowerCase().equals(givenName.toLowerCase()))
        {
            failPassText.setText("Pass");
            failPassText.setTextColor(Color.parseColor("#00ff00"));


        }
        else{
            failPassText.setText("Fail");
            failPassText.setTextColor(Color.parseColor("#ff0000"));
        }

        actualNameText.setText("Actual Name : "+ info.getName());
        givenNameText.setText("Name Given : " + givenName);


    }
}
