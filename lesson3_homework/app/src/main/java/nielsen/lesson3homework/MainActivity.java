package nielsen.lesson3homework;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import layout.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    // Initiate TAG here to tag your logs. The String the right side returns is just "MainActivity"
    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final MainActivityFragment mainActivityFragment = new MainActivityFragment();
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.holder, mainActivityFragment).commit();
        }

        final Button settingsButton = (Button) this.findViewById(R.id.settingsButton);
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // It is much better practice to use a final variable TAG here to tag your logs.
                // It is initiated at the top, as a class attribute.
                Log.d(TAG, "User clicked SETTINGS button");

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
