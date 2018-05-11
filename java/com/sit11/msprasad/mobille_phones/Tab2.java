package com.sit11.msprasad.mobille_phones;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Tab2 extends Fragment {

    Button powerbank,wireless_charger,charger;
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_tab2, container, false);
        final Context context = rootview.getContext();

        wireless_charger = (Button)rootview.findViewById(R.id.wirelessbtn);
        wireless_charger.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(getActivity(), Wireless_Charger.class);
                startActivity(intent1);
            }
        });

        charger = (Button)rootview.findViewById(R.id.chagerbtn);
        charger.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(getActivity(), Charger.class);
                startActivity(intent1);
            }
        });

        powerbank = (Button)rootview.findViewById(R.id.powerbtn);
        powerbank.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(getActivity(), Powerbank.class);
                startActivity(intent1);
            }
        });
        return rootview;
    }

}
