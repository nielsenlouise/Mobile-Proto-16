package nielsen.lesson4homework;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lnielsen on 9/19/16.
 */
public class ToDoListAdapter extends ArrayAdapter<ToDo> {
    public ToDoListAdapter(Context context, ArrayList<ToDo> toDos) {
        super(context, 0, toDos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final ToDo toDo = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_todo, parent, false);
        }
        // Lookup view for data population
        final TextView tvTextToDo = (TextView) convertView.findViewById(R.id.tvTextToDo);

        tvTextToDo.setText(toDo.getTextToDo());
        tvTextToDo.setText(toDo.isCompleted() ? String.format("%s (Completed)", toDo.getTextToDo()) : toDo.getTextToDo());

        tvTextToDo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("ToDoListAdapter", "User clicked a text view");
                // makes and alertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(R.string.dialogTitle);
                // makes the EditText final so I can access it inside other places
                final EditText editText = new EditText(getContext());
                editText.setText(toDo.getTextToDo());
                builder.setView(editText)
                        // what happens when user clicks OK
                        .setPositiveButton(R.string.editpls, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("ToDoListAdapter", "User clicked OK");
                                // makes the input something I can use
                                toDo.setTextToDo(editText.getText().toString());
                                // sets the text view to have that user input
                                tvTextToDo.setText(toDo.getTextToDo());

                            }
                        })
                        // what happens when user clicks CANCEL
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("ToDoListAdapter", "User clicked CANCEL");
                                // cancels everything and makes the dialog box go away
                                dialog.cancel();
                            }
                        });
                // shows the alertDialog
                builder.show();
            }
        });
        // Populate the data into the template view using the data object

        tvTextToDo.setText(toDo.getTextToDo());
        // Return the completed view to render on screen
        return convertView;
    }
}