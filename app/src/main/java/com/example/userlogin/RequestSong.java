package com.example.userlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.userlogin.Database.DBHelper;
import com.example.userlogin.Database.Request;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;


public class RequestSong extends AppCompatActivity {
    EditText et1 , et2;
    private Spinner spinner;
    private Button button;

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
                Request request = new Request(et2.getText().toString().trim(),et2.getText().toString().trim());
                DBHelper db = new DBHelper(RequestSong.this);

                //create insert function of DBHelper with user object passed as parameter
                long i = db.AddInfo(request);

                //obtain the return value and inform the user about the insertion with the toast
                if(i > 0){
                    Toast.makeText(RequestSong.this, "Request Sent!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RequestSong.this, "Unsent!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
