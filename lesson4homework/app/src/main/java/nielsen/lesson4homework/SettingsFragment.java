package nielsen.lesson4homework;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
//import nielsen.lesson4homework.R;

public class SettingsFragment extends Fragment {
    @BindView(R.id.colorbutton1) Button colorbutton1;
    @BindView(R.id.colorbutton2) Button colorbutton2;
    @BindView(R.id.colorbutton3) Button colorbutton3;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, view);



        colorbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingsFragment", "User clicked red color button");
                // gets the MainActivity layout as a thing I can change
                Activity a = getActivity();
                // sets the background color to red
                a.getWindow().getDecorView().setBackgroundColor(Color.rgb(255,0,0));
            }
        });

        colorbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingsFragment", "User clicked green color button");
                // gets the MainActivity layout as a thing I can change
                Activity a = getActivity();
                // sets the background color to green
                a.getWindow().getDecorView().setBackgroundColor(Color.rgb(0,255,0));
            }
        });

        colorbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingsFragment", "User clicked blue color button");
                // gets the MainActivity layout as a thing I can change
                Activity a = getActivity();
                // sets the background color to blue
                a.getWindow().getDecorView().setBackgroundColor(Color.rgb(0,0,255));
            }
        });

        return view;
    }

}