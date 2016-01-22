package com.hackathon.cheherlock.activity;

/**
 * Created by Ravinder Nath Kamra on 7/18/2015.
 */
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dexafree.materialList.view.MaterialListView;
import com.hackathon.cheherlock.R;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Tab4 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.tab_4,container,false);

        /*
        MaterialListView mListView = (MaterialListView) v.findViewById(R.id.material_listview);


        Card card = new Card.Builder(this.getActivity())
                .withProvider(BasicImageButtonsCardProvider.class)
                .setTitle("Stadium 1")
                .setDescription("Nice outfield perfect pitch for Leather Ball")
                .setDrawable(R.drawable.oval)
                .setLeftButtonText("More")
                .setRightButtonText("Call")
                .setOnLeftButtonClickListener(this)
                .setOnLeftButtonClickListener(this)
                .endConfig()
                .build();
        card.setTag("Card1");
        /*
        BigImageButtonsCard card2 = new BigImageButtonsCard(this.getActivity());
        card2.setTitle("Another title");
        card2.setDescription("Another description");
        card2.setLeftButtonText("LEFT");
        card2.setRightButtonText("RIGHT");
        card2.setDrawable(R.drawable.oval);*/

        //mListView.add(card);
        return v;
    }


}

