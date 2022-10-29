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

 public class ManageRequest extends AppCompatActivity {

 RecyclerView recyclerView;
 MyAdapter myAdapter;
 ArrayList<String> name,song,type;
 DBHelper db;

 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_manage_request);

 recyclerView = findViewById(R.id.requestlist);
 name = new ArrayList<>();
 song = new ArrayList<>();
 type = new ArrayList<>();
 db = new DBHelper(this);
 recyclerView.setLayoutManager(new LinearLayoutManager(this));
 recyclerView.setAdapter(myAdapter);
 myAdapter = new MyAdapter(this, name,song,type);
 displayData();


 }

 private void displayData() {
 Cursor c = db.getRequest();
 if(c.getCount()==0){
 Toast.makeText(this, "No Data Exists", Toast.LENGTH_SHORT).show();
 return;
 }
 else{
 while(c.moveToNext()){
 name.add(c.getString(1));
 song.add(c.getString(2));
 type.add(c.getString(3));
 }
 }
 }
 }
