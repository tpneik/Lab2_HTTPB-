package com.example.login_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        MaterialButton createbtn = (MaterialButton) findViewById(R.id.createbtn);
        t1 = (TextView)findViewById(R.id.nwname) ;
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {openLogs();}
        });
    }
    public void openLogs(){
        Intent intent = new Intent(this, Logs.class);
        startActivity(intent);
    }


}