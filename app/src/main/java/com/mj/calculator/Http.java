package com.mj.calculator;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by txiaozhe on 04/12/2017.
 */

public class Http implements Tools{
    public void get() {
        String url = "http://data.bank.hexun.com/other/cms/fxjhjson.ashx?callback=PereMoreData";
        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    @Override
    public void onSuccess() {
        
    }
}
