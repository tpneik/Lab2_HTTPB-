package com.example.login_lab2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.button.MaterialButton;

import org.json.JSONArray;
import org.json.JSONObject;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    String t1, t2;

    JSONObject jsonBody = new JSONObject();
    JSONObject identity = new JSONObject();
    JSONObject methods = new JSONObject();
    JSONArray passwordArray = new JSONArray();
    JSONObject password = new JSONObject();
    JSONObject user = new JSONObject();
    JSONObject domain = new JSONObject();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);

        t1 = username.toString();
        t2 = password.toString();
        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        MaterialButton signupbtn = (MaterialButton) findViewById(R.id.signupbtn);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    getApiData();
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignup();
            }
        });
    }
    public void openSignup(){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }

    public void getApiData() throws UnsupportedEncodingException {
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "http://192.168.27.10:5000/v3/auth/tokens";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("MyRespond",response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("MyRespond","fail");
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("name", t1);
                params.put("password",t2);
                return params;
            };

        };
        requestQueue.add(stringRequest);
    }


}