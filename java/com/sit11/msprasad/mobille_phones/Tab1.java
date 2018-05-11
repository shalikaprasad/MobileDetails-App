package com.sit11.msprasad.mobille_phones;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.v4.app.FragmentTransaction;


public class Tab1 extends Fragment
{
    Button microsoft ;
    Button htc ;
    Button sam ;
    Button lg,black ,apple,huwave,sony;
    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View rootview = inflater.inflate(R.layout.fragment_tab1, container, false);
        Context context = rootview.getContext();

        try
        {
            htc = (Button)rootview.findViewById(R.id.htcbtn);
            htc.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view1)
                {
                    Intent intent2 = new Intent(getActivity(), HTCPhone.class);
                    startActivity(intent2);
                }
            });

            sony = (Button)rootview.findViewById(R.id.sonybtn);
            sony.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view1)
                {
                    Intent intent2 = new Intent(getActivity(), Sony.class);
                    startActivity(intent2);
                }
            });

            microsoft = (Button)rootview.findViewById(R.id.microsoftbtn);
            microsoft.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent = new Intent(getActivity(), Microsoft.class);
                    startActivity(intent);
                }
            });

            sam = (Button)rootview.findViewById(R.id.samsungbtn);
            sam.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent3 = new Intent(getActivity(), Samsung.class);
                    startActivity(intent3);
                }
            });

            lg = (Button)rootview.findViewById(R.id.lgbtn);
            lg.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent3 = new Intent(getActivity(), Lg.class);
                    startActivity(intent3);
                }
            });

            black = (Button)rootview.findViewById(R.id.blckbtn);
            black .setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent3 = new Intent(getActivity(), Blackberry.class);
                    startActivity(intent3);
                }
            });

            apple = (Button)rootview.findViewById(R.id.applebtn);
            apple.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent3 = new Intent(getActivity(), Apple.class);
                    startActivity(intent3);
                }
            });

            huwave = (Button)rootview.findViewById(R.id.huawiebtn);
            huwave .setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent3 = new Intent(getActivity(), Huawei.class);
                    startActivity(intent3);
                }
            });

        }catch (Exception e){

        }

    return rootview;
    }


}
