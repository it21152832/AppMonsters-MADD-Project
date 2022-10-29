package com.example.userlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.userlogin.Database.DBHelper;
import com.example.userlogin.Database.Request;
import com.example.userlogin.Database.RequestMaster;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class RequestSong extends AppCompatActivity {
    EditText et1 , et2;
    private Spinner spinner;
    private Button button;

    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_song);
        et1 = findViewById(R.id.artistname);
        et2 = findViewById(R.id.songtitle);
        spinner = findViewById(R.id.type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.request_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        button = findViewById(R.id.add);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //create user object
                //insert user name values to the user objects
                Request r = new Request(et1.getText().toString().trim() , et2.getText().toString().trim(),spinner.getSelectedItem().toString());

                //create an object of DBHelper
                DBHelper db = new DBHelper(RequestSong.this);

                //create insert function of DBHelper with user object passed as parameter
                long i = db.AddInfo(r);

                //obtain the return value and inform the user about the insertion with the toast
                if(i > 0){
                    Toast.makeText(RequestSong.this, "Request Sent!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RequestSong.this, "Unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
