package nielsen.lesson4homework;

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

import nielsen.lesson3homework.R;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        Button colorbutton1 = (Button) view.findViewById(R.id.colorbutton1);
        colorbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingsFragment", "User clicked red color button");
                // gets the MainActivity layout as a thing I can change
                View mainActivityView = getActivity().findViewById(R.id.mainLayout);
                // sets the background color to red
                mainActivityView.setBackgroundColor(Color.argb(255,255,0,0));
            }
        });

        Button colorbutton2 = (Button) view.findViewById(R.id.colorbutton2);
        colorbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingsFragment", "User clicked green color button");
                // gets the MainActivity layout as a thing I can change
                View mainActivityView = getActivity().findViewById(R.id.mainLayout);
                // sets the background color to green
                mainActivityView.setBackgroundColor(Color.argb(255,0,255,0));
            }
        });

        Button colorbutton3 = (Button) view.findViewById(R.id.colorbutton3);
        colorbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingsFragment", "User clicked blue color button");
                // gets the MainActivity layout as a thing I can change
                View mainActivityView = getActivity().findViewById(R.id.mainLayout);
                // sets the background color to blue
                mainActivityView.setBackgroundColor(Color.argb(255,0,0,255));
            }
        });

        return view;
    }

}
