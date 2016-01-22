package com.hackathon.cheherlock.activity;

/**
 * Created by Ravinder Nath Kamra on 7/18/2015.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.util.JsonReader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
import com.hackathon.cheherlock.parsejson.ParseStadium;
import com.hackathon.cheherlock.session.SettingsVariables;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab2 extends Fragment implements IWebConnected {

    SettingsVariables sv = SettingsVariables.GetSettingVariables();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2, container, false);
        return v;
    }

    @Override
    public void setView(ArrayList<? extends SportusBusinessObject> sbo) {
        MaterialListView mListView = (MaterialListView) this.getActivity().findViewById(R.id.stadium_listview);
        for (int i = 0; i < sbo.size(); i++) {
            SBO_Stadium stadium = (SBO_Stadium) sbo.get(i);
            BigImageButtonsCard card2 = new BigImageButtonsCard(this.getActivity());
            card2.setTitle(stadium.getGround_name());
            card2.setDescription(stadium.getGround_address() + "\n" + String.valueOf(stadium.getGround_fee()));
            card2.setLeftButtonText("More");
            card2.setRightButtonText("Call");
            card2.setDrawable(R.drawable.oval);
            card2.setDividerVisible(true);

            mListView.add(card2);
        }

    }
}

