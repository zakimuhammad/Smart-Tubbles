package com.example.zaki.smarttubbles;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txt_username;
    TextView txt_nama;
    TextView txt_email;
    ImageView tambal;
    Button btn_logout;
    String username, nama,email;
    SharedPreferences sharedpreferences;

    public static final String TAG_USERNAME = "username";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_EMAIL ="email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        btn_logout = findViewById(R.id.btn_logout);
        txt_username = findViewById(R.id.username);
        txt_nama  = findViewById(R.id.user);
        txt_email = findViewById(R.id.email);
        tambal = findViewById(R.id.tambal);
        sharedpreferences = getSharedPreferences(LoginActivity.my_shared_preferences, Context.MODE_PRIVATE);
        username = getIntent().getStringExtra(TAG_USERNAME);
        nama = getIntent().getStringExtra(TAG_NAMA);
        email = getIntent().getStringExtra(TAG_EMAIL);
        txt_username.setText(username);
        txt_nama.setText(nama);
        txt_email.setText(email);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putBoolean(LoginActivity.session_status,false);
                editor.putString(TAG_USERNAME, null);
                editor.commit();

                Intent intent = new Intent(SecondActivity.this, LoginActivity.class);
                finish();
                startActivity(intent);
            }
        });

        tambal.setOnClickListener((new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MapsActivity.class);
                finish();
                startActivity(intent);
            }
        }));
    }

    public void map(){
        Intent intent = new Intent(SecondActivity.this, MapsActivity.class);
        finish();
        startActivity(intent);
    }
}
