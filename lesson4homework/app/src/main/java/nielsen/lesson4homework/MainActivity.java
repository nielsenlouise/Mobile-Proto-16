package nielsen.lesson4homework;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private FloatingActionButton addButton;
    private ListView listView;
    private ArrayList<ToDo> toDos;
    public ArrayAdapter<ToDo> toDoArrayAdapter;
    private Button settingsButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settingsButton = (Button) findViewById(R.id.settingsButton);
        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.lvToDos);
        addButton = (FloatingActionButton) findViewById(R.id.addButton);
        toDos = new ArrayList<>();
        toDoArrayAdapter = new ToDoListAdapter(this, toDos);

        listView.setAdapter(toDoArrayAdapter);
        // I think the reason the app is crashing is listView is null
        // The fragment which holds these have not been created yet
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDos.add(new ToDo(editText.getText().toString(), false));
                editText.setText("@string/editpls");
                toDoArrayAdapter.notifyDataSetChanged();
            }
        });



        final MainActivityFragment mainActivityFragment = new MainActivityFragment();
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.holder, mainActivityFragment).commit();
        }

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // You can also use TAG in log statements
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