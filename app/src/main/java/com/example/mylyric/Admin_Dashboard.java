package com.example.mylyric;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_Dashboard extends AppCompatActivity {

    Button request,song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        request = findViewById(R.id.request);
        song = findViewById(R.id.song);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                request();
            }
        });

        song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Admin_Dashboard.this, EditDeleteRequest.class));
            }
        });
    }

    private void request() {
        Intent intent = new Intent(Admin_Dashboard.this, ManageRequest.class);
        startActivity(intent);
    }

}