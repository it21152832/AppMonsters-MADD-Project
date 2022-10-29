package com.example.mylyric;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.mylyric.Database.DBHelper;
import com.example.mylyric.Database.Request;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class RequestManage extends AppCompatActivity {

    DBHelper db;
    Button add1, edit1, delete1,add2,edit2,delete2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_request);

        db = new DBHelper(this);
        add1 = findViewById(R.id.add3);
        add2 = findViewById(R.id.add2);
        edit1 = findViewById(R.id.edit3);
        edit2 = findViewById(R.id.edit2);
        delete1 = findViewById(R.id.delete3);
        delete2 = findViewById(R.id.delete2);

        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });

        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });

        edit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });

        edit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });

        delete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });

        delete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send();
            }
        });


    }

    private void send() {
        Intent intent = new Intent(this,EditDeleteRequest.class);
        startActivity(intent);
    }


}