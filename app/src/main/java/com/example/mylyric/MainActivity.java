package com.example.mylyric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        if(username.getText().toString().equals("admin") &&  password.getText().toString().equals("1234")){
            Intent intent = new Intent(this , Admin_Dashboard.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
        }

    }
}