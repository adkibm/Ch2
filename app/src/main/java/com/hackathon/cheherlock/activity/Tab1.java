package com.hackathon.cheherlock.activity;

/**
 * Created by Ravinder Nath Kamra on 7/18/2015.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dexafree.materialList.cards.BasicImageButtonsCard;
import com.dexafree.materialList.cards.OnButtonPressListener;
import com.dexafree.materialList.model.Card;
import com.dexafree.materialList.view.MaterialListView;
import com.hackathon.cheherlock.R;
import com.hackathon.cheherlock.network.WebCallerAPI;
import com.hackathon.cheherlock.parsejson.ParseTagImageResponse;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;


/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(com.hackathon.cheherlock.R.layout.tab_1,container,false);
        addCards(v);
        return v;
    }

    public void addCards(View v)
    {


        BasicImageButtonsCard card1 = new BasicImageButtonsCard(this.getActivity().getApplicationContext());
        card1.setTitle("Hrithik Roshan");
        card1.setDescription("Tenant");
        card1.setDrawable(R.drawable.ic_hrithik);
        card1.setLeftButtonText("Edit");
        card1.setRightButtonText("Verify");

        card1.setOnRightButtonPressedListener(new OnButtonPressListener() {
            @Override
            public void onButtonPressedListener(View view, Card card) {
                CallMainActivity("http://static.dnaindia.com/sites/default/files/2015/10/23/387977-hrithik-hi-res-2.jpg","Hrithik Roshan");

            }
        });
        card1.setOnLeftButtonPressedListener(new OnButtonPressListener() {
            @Override
            public void onButtonPressedListener(View view, Card card) {

            }
        });

        BasicImageButtonsCard card2 = new BasicImageButtonsCard(this.getActivity().getApplicationContext());
        card2.setTitle("Shamsher Singh");
        card2.setDescription("Tenant");
        card2.setDrawable(R.drawable.ic_shahrukh);
        card2.setLeftButtonText("Edit");
        card2.setRightButtonText("Verify");
        card2.setOnRightButtonPressedListener(new OnButtonPressListener() {
            @Override
            public void onButtonPressedListener(View view, Card card) {
                CallMainActivity("http://www-cdn.oneindia.com/img/2015/03/20-1426854762-shahrukh-khan-best-actor-oneindia-poll.jpg","Shamsher Singh");

            }
        });
        card2.setOnLeftButtonPressedListener(new OnButtonPressListener() {
            @Override
            public void onButtonPressedListener(View view, Card card) {

            }
        });

        BasicImageButtonsCard card3 = new BasicImageButtonsCard(this.getActivity().getApplicationContext());
        card3.setTitle("Sunder Singh");
        card3.setDescription("Cook");
        card3.setDrawable(R.drawable.ic_ranveer);
        card3.setLeftButtonText("Edit");
        card3.setRightButtonText("Verify");

        card3.setOnRightButtonPressedListener(new OnButtonPressListener() {
            @Override
            public void onButtonPressedListener(View view, Card card) {

                CallMainActivity("http://www.shortday.in/wp-content/uploads/2015/05/ranveer-singh-smart.jpg","Sunder Singh");

            }
        });
        card3.setOnLeftButtonPressedListener(new OnButtonPressListener() {
            @Override
            public void onButtonPressedListener(View view, Card card) {

            }
        });

        MaterialListView mListView = (MaterialListView) v.findViewById(R.id.material_listview);

        mListView.add(card1);
        mListView.add(card2);
        mListView.add(card3);


    }

    public void CallMainActivity(String url,String givenName) {
        ((MainActivity)this.getActivity()).CallResultActivity(url,givenName);
    }
}
