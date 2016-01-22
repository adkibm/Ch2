package com.hackathon.cheherlock.activity;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.dexafree.materialList.cards.BigImageButtonsCard;
import com.dexafree.materialList.view.MaterialListView;
import com.hackathon.cheherlock.R;
import com.hackathon.cheherlock.business.SBO_City;
import com.hackathon.cheherlock.business.SBO_Sport;
import com.hackathon.cheherlock.business.SBO_Stadium;
import com.hackathon.cheherlock.interfaces.IWebConnected;
import com.hackathon.cheherlock.interfaces.SportusBusinessObject;
import com.hackathon.cheherlock.network.WebCallerAPI;
import com.hackathon.cheherlock.parsejson.ParseCity;
import com.hackathon.cheherlock.parsejson.ParseStadium;
import com.hackathon.cheherlock.session.SettingsVariables;

import java.util.ArrayList;


/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab3 extends Fragment implements IWebConnected {

    //final int TOTAL_CARDS = 3;
    SettingsVariables sv = SettingsVariables.GetSettingVariables();

    //private CardArrayAdapter

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_3,container,false);


        return v;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void setView(ArrayList<? extends SportusBusinessObject> sbo) {

       // ShowLoadingView(false);
        //Toast.makeText(Tab3.this.getActivity(),((SBO_City)sbo.get(0)).getName(),Toast.LENGTH_SHORT).show();
    }



}

