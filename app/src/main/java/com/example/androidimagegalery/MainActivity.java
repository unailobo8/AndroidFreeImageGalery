package com.example.androidimagegalery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    private final String API_KEY = "563492ad6f9170000100000178b2ac16f5b5446a9f3817fa46c5088d";

    EditText findQuery;
    Button findButton;
    ProgressBar progressBar;
    static List<Foto> fotos = new ArrayList<>();
    static int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findQuery = (EditText) findViewById(R.id.findQuery);
        findButton = (Button) findViewById(R.id.findButton);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LeerApi();
            }
        });
    }

    private void LeerApi() {
        progressBar.setVisibility(View.VISIBLE);
        Editable query = findQuery.getText();
        String url = "https://api.pexels.com/v1/search?query=" + query;
        StringRequest getRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    fotos.clear();
                    JSONObject initial = new JSONObject(response);
                    JSONArray jsonArray = initial.getJSONArray("photos");
                    if(jsonArray == null || jsonArray.length() == 0){
                        Toast.makeText(MainActivity.this, getResources().getText(R.string.search_error), Toast.LENGTH_LONG).show();
                        progressBar.isIndeterminate();
                        progressBar.setVisibility(View.GONE);
                    }else{
                        for (int i = 0; i < jsonArray.length() -1; i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            Foto foto = new Foto(
                                    jsonObject.getInt("id"),
                                    jsonObject.getInt("width"),
                                    jsonObject.getInt("height"),
                                    jsonObject.getString("url"),
                                    jsonObject.getString("alt"),
                                    jsonObject.getJSONObject("src").getString("medium")
                            );
                            fotos.add(foto);
                        }
                        progressBar.isIndeterminate();
                        progressBar.setVisibility(View.GONE);
                        Intent intent = new Intent(MainActivity.this, ImageList.class);
                        MainActivity.this.startActivity(intent);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
;            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                params.put("Authorization", API_KEY);
                return params;
            }
        };
        Volley.newRequestQueue(this).add(getRequest);
    }
}