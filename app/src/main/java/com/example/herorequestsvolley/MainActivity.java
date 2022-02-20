package com.example.herorequestsvolley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.herorequestsvolley.adapter.Hero;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RequestQueue queue;
    ArrayList<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnJson).setOnClickListener(v -> stringRequest());
        queue = Volley.newRequestQueue(this);
    }

    /*private void jsonRequest() {
        JsonRequest jsonRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://simplifiedcoding.net/demos/view-flipper/heroes.php",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("heroes");
                            Log.d("JSONArray", jsonArray.toString());


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                error -> {
                    error.printStackTrace();
                }
        );
        queue.add(jsonRequest);
    }*/

    private void stringRequest() {
        // Instantiate the RequestQueue.

        String url ="https://simplifiedcoding.net/demos/view-flipper/heroes.php";

        // Request a string response from the provided URL.
        StringRequest stringRequest =
                new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // Display the first 500 characters of the response string.
                                //txt.setText("Response is: "+ response.substring(0,500));
                                Log.d("json", "Response is: "+ response);
                                heroList = new ArrayList<>();

                                


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //txt.setText("That didn't work!" + error.toString());
                        Log.d("Error", "That didn't work!" + error.toString());
                    }
                });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
