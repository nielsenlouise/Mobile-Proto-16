package nielsen.lesson4homework;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

//import layout.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.settingsButton) Button settingsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


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