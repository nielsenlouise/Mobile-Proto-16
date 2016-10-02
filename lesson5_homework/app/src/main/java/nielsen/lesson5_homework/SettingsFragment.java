package nielsen.lesson5_homework;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//import nielsen.lesson4homework.R;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_settings, container, false);

        Button colorbutton1 = (Button) view.findViewById(R.id.colorbutton1);
        Button colorbutton2 = (Button) view.findViewById(R.id.colorbutton2);
        Button colorbutton3 = (Button) view.findViewById(R.id.colorbutton3);

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        int defaultValue = ContextCompat.getColor(getContext(), R.color.saved_background_default);
        int background = sharedPref.getInt(getString(R.string.saved_background), defaultValue);
        Activity a = getActivity();
        a.getWindow().getDecorView().setBackgroundColor(background);
        // SharedPref looks really nice

        // This whitespace is not needed. Get rid of it?


        colorbutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingsFragment", "User clicked red color button");
                // gets the MainActivity layout as a thing I can change
                Activity a = getActivity();
                // sets the background color to red
                // You repeat the next few lines of code three times. Putting it in a method will make the code more readable
                int currentBackground = ContextCompat.getColor(getContext(), R.color.red);
                a.getWindow().getDecorView().setBackgroundColor(currentBackground);
                SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                // Would like more
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt(getString(R.string.saved_background), currentBackground);
                editor.apply();
            }
        });

        colorbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingsFragment", "User clicked green color button");
                // gets the MainActivity layout as a thing I can change
                Activity a = getActivity();
                // sets the background color to green
                int currentBackground = ContextCompat.getColor(getContext(), R.color.green);
                a.getWindow().getDecorView().setBackgroundColor(currentBackground);
                SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt(getString(R.string.saved_background), currentBackground);
                editor.apply();
            }
        });

        colorbutton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("SettingsFragment", "User clicked blue color button");
                // gets the MainActivity layout as a thing I can change
                Activity a = getActivity();
                // sets the background color to blue
                int currentBackground = ContextCompat.getColor(getContext(), R.color.blue);
                a.getWindow().getDecorView().setBackgroundColor(currentBackground);
                SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt(getString(R.string.saved_background), currentBackground);
                editor.apply();
            }
        });

        return view;
    }

}