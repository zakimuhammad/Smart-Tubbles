package com.example.zaki.smarttubbles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editText1,editText2;
    String text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Smart Tubbles");
    }

    public void loginMasuk(View view){
        editText1 = (EditText)findViewById(R.id.edittext_username);
        editText2 = (EditText)findViewById(R.id.edittext_password);
        text1 = editText1.getText().toString();
        text2 = editText2.getText().toString();

        if((text1.contains("Username"))&&((text2.contains("Password")))){
            Toast.makeText(this, "Login Sukses", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        else if((text1.matches("")||text2.matches(""))){
            Toast.makeText(this, "Isikan Username dan Password", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_SHORT).show();
        }
    }

    public void register(View view){
        Intent intent= new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }
}
