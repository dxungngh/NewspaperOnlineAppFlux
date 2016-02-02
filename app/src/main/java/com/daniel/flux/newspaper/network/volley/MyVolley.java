package com.daniel.flux.newspaper.network.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by danielnguyen on 1/13/16.
 */
public class MyVolley {
    public static final String TAG = MyVolley.class.getSimpleName();

    private RequestQueue requestQueue;

    public MyVolley(Context context) {
        this.requestQueue = Volley.newRequestQueue(context);
    }

    public <T> void addToRequestQueue(Request<T> request) {
        this.requestQueue.add(request);
    }
}