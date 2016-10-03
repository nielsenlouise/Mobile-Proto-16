package mobile_proto_16.com.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;

import butterknife.BindView;
import butterknife.ButterKnife;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    @BindView(R.id.button) Button button;
    @BindView(R.id.input) EditText input;
    @BindView(R.id.price) TextView price;

    private final String TAG = this.getClass().getName();

    private Response.Listener<String> responseListener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            String subResponse = response.substring(3);
            try {
                // thanks matt ruehle
                JSONArray j = new JSONArray(subResponse);
                String s = extractPriceFromJSON(j);
                price.setText(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, "A VolleyError occurred.");
            error.printStackTrace();
        }
    };

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        final Context c = this.getContext();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = buildSearchURL(input.getText().toString());
                // Request a string response from the provided URL.
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener, errorListener);
                // Add request to RequestQueue
                MySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
            }
        });

        return view;
    }

    private String buildSearchURL(String companyTicker) {
        // thanks stack overflow
        // also thanks david (probably) for giving us the link to that stack overflow
        // http://stackoverflow.com/questions/19167954/use-uri-builder-in-android-or-create-url-with-variables
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("finance.google.com")
                .appendPath("finance")
                .appendPath("info")
                .appendQueryParameter("client", "iq")
                .appendQueryParameter("q", companyTicker);
        return builder.build().toString();
    }

    private String extractPriceFromJSON(JSONArray array) throws JSONException {
        // Extract the price value from the JSON array
        return array.getJSONObject(0).getString("l_cur") + "";
    }

}
