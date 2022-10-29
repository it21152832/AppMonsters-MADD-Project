package com.first.mylyric_playlists;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    String pl_list[] = {"Favourites","Mood","Addicted","Dance","Nostalgic","Childhood","Ballad","Slow..","90's","Old song list","Night playlist","Sleep.."};
    String pl_desc[] = {"My fav songs","Suiting the mood...","Fav of favs","dance tunes","Bringing back memories..","Childhood favs","Best ballads","Sloww tunes","fav from 90's","fav old songs","play at bedtime","Zzz..."};
    String pl_created[] = {"10/30/2022","10/25/2022","10/25/2022","10/25/2022","10/25/2022","10/25/2022","10/25/2022","10/25/2022","10/24/2022","10/24/2022","10/24/2022","10/24/2022"};

    ListView listView;

    Button btn_sg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = (ListView) findViewById(R.id.list_pl2);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(),pl_list,pl_desc,pl_created);
        listView.setAdapter(customBaseAdapter);

        btn_sg = (Button) findViewById(R.id.btn_sgs2);

        btn_sg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}