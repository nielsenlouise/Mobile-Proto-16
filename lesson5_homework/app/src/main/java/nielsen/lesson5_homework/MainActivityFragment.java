package nielsen.lesson5_homework;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import static nielsen.lesson5_homework.R.id.addButton;
import static nielsen.lesson5_homework.R.id.editText;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private EditText editText;
    private FloatingActionButton addButton;
    private ListView listView;
    private ArrayList<ToDo> toDos;
    public ArrayAdapter<ToDo> toDoArrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // instantiate a ToDoSQLHelper instance
        // read it

        editText = (EditText) view.findViewById(R.id.editText);
        listView = (ListView) view.findViewById(R.id.lvToDos);
        addButton = (FloatingActionButton) view.findViewById(R.id.addButton);
        toDos = new ArrayList<>();
        toDoArrayAdapter = new ToDoListAdapter(getContext(), toDos);

        listView.setAdapter(toDoArrayAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDo newToDo = new ToDo("Add something to do!");
                toDoArrayAdapter.add(newToDo);
                ToDoSQLHelper mDbHelper = new ToDoSQLHelper(getContext());
                mDbHelper.addToDo("Add something to do!", false);
            }
        });

        return view;
    }
}