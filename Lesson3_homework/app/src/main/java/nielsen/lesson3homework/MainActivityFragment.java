package nielsen.lesson3homework;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView myTextView1 = (TextView) view.findViewById(R.id.textView1);
        TextView myTextView2 = (TextView) view.findViewById(R.id.textView2);
        TextView myTextView3 = (TextView) view.findViewById(R.id.textView3);
        TextView myTextView4 = (TextView) view.findViewById(R.id.textView4);
        TextView myTextView5 = (TextView) view.findViewById(R.id.textView5);


        myTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                TODO: add a text entry place and everything else after that (custom things)
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                Log.d("MainActivityFragment", "onClickListener got hit");
                EditText edit_text = new EditText(v.getContext());
                builder.setMessage(R.string.dialogMessage)
                        .setView(edit_text)
                        .setTitle(R.string.dialogTitle)
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Log.d("MainActivityFragment", "User clicked OK");
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Log.d("MainActivityFragment", "User clicked Cancel");
                            }
                        });
                builder.show();
            }
        });


        return view;
    }
}
