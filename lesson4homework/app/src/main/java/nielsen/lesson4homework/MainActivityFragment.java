package nielsen.lesson4homework;

import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ArrayList<ToDo> arrayOfToDos = new ArrayList<>();
        final ToDoListAdapter adapter = new ToDoListAdapter(getContext(), arrayOfToDos);
        ListView listView = (ListView) view.findViewById(R.id.lvToDos);
        listView.setAdapter(adapter);
        FloatingActionButton myAddButton = (FloatingActionButton) view.findViewById(R.id.addButton);
        myAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToDo newToDo = new ToDo("Add something to do!", false);
                adapter.add(newToDo);
            }
        });

        return view;
    }
}