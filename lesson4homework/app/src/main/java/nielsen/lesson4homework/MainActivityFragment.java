package nielsen.lesson4homework;

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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    @BindView(R.id.textView1) TextView myTextView1;
    @BindView(R.id.textView2) TextView myTextView2;
    @BindView(R.id.textView3) TextView myTextView3;
    @BindView(R.id.textView4) TextView myTextView4;
    @BindView(R.id.textView5) TextView myTextView5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        // sets onClickListeners for all my text views
        myTextView1.setOnClickListener(onItemClick);
        myTextView2.setOnClickListener(onItemClick);
        myTextView3.setOnClickListener(onItemClick);
        myTextView4.setOnClickListener(onItemClick);
        myTextView5.setOnClickListener(onItemClick);

        return view;
    }

    public View.OnClickListener onItemClick = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {
            Log.d("MainActivityFragment", "User clicked a text view");
            // makes and alertDialog
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle(R.string.dialogTitle);
            // makes the EditText final so I can access it inside other places
            final EditText editText = new EditText(v.getContext());
            builder.setView(editText)
                    // what happens when user clicks OK
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d("MainActivityFragment", "User clicked OK");
                            // makes the input something I can use
                            String textInput = editText.getText().toString();
                            // sets the text view to have that user input
                            ((TextView) v).setText(textInput);

                        }
                    })
                    // what happens when user clicks CANCEL
                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.d("MainActivityFragment", "User clicked CANCEL");
                            // cancels everything and makes the dialog box go away
                            dialog.cancel();
                        }
                    });
            // shows the alertDialog
            builder.show();

        }
    };
}