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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        TextView myTextView1 = (TextView) view.findViewById(R.id.textView1);
        TextView myTextView2 = (TextView) view.findViewById(R.id.textView2);
        TextView myTextView3 = (TextView) view.findViewById(R.id.textView3);
        TextView myTextView4 = (TextView) view.findViewById(R.id.textView4);
        TextView myTextView5 = (TextView) view.findViewById(R.id.textView5);
        myTextView1.setOnClickListener(onItemClick);
        myTextView2.setOnClickListener(onItemClick);
        myTextView3.setOnClickListener(onItemClick);
        myTextView4.setOnClickListener(onItemClick);
        myTextView5.setOnClickListener(onItemClick);

        return view;
    }

    public View.OnClickListener onItemClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("MainActivityFragment", "User clicked a text view");
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle(R.string.dialogTitle)
                    .setMessage(R.string.dialogMessage);
            final EditText editText = new EditText(v.getContext());
            builder.setView(editText)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d("MainActivityFragment", "User clicked OK");
                        }
                    })
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d("MainActivityFragment", "User clicked CANCEL");
                        }
                    });
            builder.show();

        }
    };
}
