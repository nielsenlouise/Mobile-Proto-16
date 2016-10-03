
package mobile_proto_16.com.myapplication;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private MySingleton(Context context) {
        mCtx = context;
        this.mRequestQueue = this.getRequestQueue();
    }

    public static synchronized MySingleton getInstance(Context context) {
        if(mInstance == null) {
            mInstance = new MySingleton(context);
        }

        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if(this.mRequestQueue == null) {
            this.mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }

        return this.mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        this.getRequestQueue().add(req);
    }
}
