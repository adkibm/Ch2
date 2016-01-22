package com.hackathon.cheherlock.activity;

import android.Manifest;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.cheherlock.*;
import com.hackathon.cheherlock.activity.FragmentDrawer;
import com.hackathon.cheherlock.adapter.*;
import com.hackathon.cheherlock.business.SBO_City;
import com.hackathon.cheherlock.business.SBO_ImageInfo;
import com.hackathon.cheherlock.business.SBO_Sport;
import com.hackathon.cheherlock.interfaces.IWebConnected;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;
import com.hackathon.cheherlock.model.*;
import com.hackathon.cheherlock.network.WebCallerAPI;
import com.hackathon.cheherlock.parsejson.ParseTagImageResponse;
import com.hackathon.cheherlock.session.SettingsVariables;
import com.hackathon.cheherlock.R;
import com.ibm.watson.developer_cloud.alchemy.v1.AlchemyVision;
import com.ibm.watson.developer_cloud.alchemy.v1.model.ImageFaces;
import com.squareup.okhttp.HttpUrl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements IWebConnected,com.hackathon.cheherlock.activity.FragmentDrawer.FragmentDrawerListener {


    private Toolbar mToolbar,mInfoToolbar;
    private com.hackathon.cheherlock.activity.FragmentDrawer drawerFragment;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"My Profiles"};
    //CharSequence Titles[]={"Organizer","Grounds","Tournament","Teams"};
   //CharSequence Titles[]={"Tab 1","Tab 2","Tab 3","Teb 4"};
    int Numboftabs =1;
    SettingsVariables sv = SettingsVariables.GetSettingVariables();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView(R.layout.login_activity);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        //mInfoToolbar = (Toolbar) findViewById(R.id.infotoolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Toast.makeText(getBaseContext(), "Before This", Toast.LENGTH_LONG).show();
        drawerFragment = (FragmentDrawer)
                this.getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);

        //Toast.makeText(getBaseContext(), "After This", Toast.LENGTH_LONG).show();
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

       // Assiging the Sliding Tab Layout View
       tabs = (SlidingTabLayout) findViewById(R.id.tabs);
       tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
         @Override
          public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
                }
            });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);
        //Toast.makeText(this, ((SBO_City) sv.getCityForSession()).getName() + " - " + ((SBO_Sport)sv.getSportForSession()).getName(), Toast.LENGTH_SHORT).show();

       // Toolbar toolbar = getActionBarToolbar()

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setSubtitle("");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_search)
        {
            mToolbar.setTitle("Cricket");
            mToolbar.setSubtitle("Delhi & NCR");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

    }

    public void CallResultActivity(String url,String givenName) {
        Intent intent = new Intent(getApplicationContext(), SearchFilterActivity.class);
        intent.putExtra("url",url);
        intent.putExtra("given_name",givenName);
        startActivity(intent);
        /*
       ;*/
    }

    @Override
    public void setView(ArrayList<? extends SportusBusinessObject> sbo) {


    }

}