package nielsen.lesson4homework;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Button settingsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingsButton = (Button) findViewById(R.id.settingsButton);


        final MainActivityFragment mainActivityFragment = new MainActivityFragment();
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.holder, mainActivityFragment).commit();
        }

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "User clicked SETTINGS button");

                if (settingsButton.getText() == getString(R.string.settings)){
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.holder, new SettingsFragment())
                            .addToBackStack(null).commit();
                    settingsButton.setText(R.string.back);
                } else {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.holder, mainActivityFragment)
                            .addToBackStack(null).commit();
                    settingsButton.setText(R.string.settings);
                }
            }
        });

    }
}