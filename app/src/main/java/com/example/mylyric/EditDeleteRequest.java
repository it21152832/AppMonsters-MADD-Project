package com.example.mylyric;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mylyric.Database.DBHelper;
import com.example.mylyric.Database.Request;


public class EditDeleteRequest extends AppCompatActivity {

    Button add,delete,edit;
    EditText et1,et2;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_delete_request);

        et1 = findViewById(R.id.artistname);
        et2 = findViewById(R.id.songtitle);
        spinner = findViewById(R.id.rtype);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.edit);
        edit = findViewById(R.id.delete);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.request_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Request r = new Request(et1.getText().toString().trim() , et2.getText().toString().trim(),spinner.getSelectedItem().toString());

                //create an object of DBHelper
                DBHelper db = new DBHelper(EditDeleteRequest.this);

                //create insert function of DBHelper with user object passed as parameter
                long i = db.AddInfo(r);

                //obtain the return value and inform the user about the insertion with the toast
                if(i > 0){
                    Toast.makeText(EditDeleteRequest.this, "Accepted!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditDeleteRequest.this, "Unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }

        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Request r = new Request(et1.getText().toString().trim() , et2.getText().toString().trim(),spinner.getSelectedItem().toString());

                DBHelper db = new DBHelper(EditDeleteRequest.this);

                if(db.updateUser(r)){
                    Toast.makeText(EditDeleteRequest.this, "Updated!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditDeleteRequest.this, "Update Unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Request r = new Request(et1.getText().toString().trim() , et2.getText().toString().trim(),spinner.getSelectedItem().toString());
                DBHelper db = new DBHelper(EditDeleteRequest.this);

                if(db.deleteUser(r)){
                    Toast.makeText(EditDeleteRequest.this, "User Deleted!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(EditDeleteRequest.this, "Delete Unsuccessful!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}