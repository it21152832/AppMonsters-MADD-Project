package com.first.mylyric_playlists;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    DBHelper helper;
    EditText TxTitle, TxDetail;
    long id;

    Button btnAdd;
    TextView selectedAdd;
    String[] songItems;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        helper = new DBHelper(this);
        id = getIntent().getLongExtra(DBHelper.row_id,0);
        TxTitle = (EditText) findViewById(R.id.txTitle_Add);
        TxDetail = (EditText) findViewById(R.id.txDetails_Add);

        btnAdd = (Button) findViewById(R.id.addsgAdd);
        selectedAdd = (TextView) findViewById(R.id.tv_sgA);

        songItems = getResources().getStringArray(R.array.Song_Item);
        checkedItems = new boolean[songItems.length];

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AddActivity.this);
                mBuilder.setTitle("SELECT SONGS");
                mBuilder.setMultiChoiceItems(songItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if(isChecked){
                            if(!mUserItems.contains(position)){
                                mUserItems.add(position);
                            }
                        } else if(mUserItems.contains(position)){
                            mUserItems.remove(position);
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for(int i = 0; i<mUserItems.size(); i++){
                            item = item + songItems[mUserItems.get(i)];
                            if(i != mUserItems.size()-1){
                                item = item + "\n\n";
                            }
                        }
                        selectedAdd.setText(item);
                    }
                });

                mBuilder.setNegativeButton("Dissmiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                mBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for(int i = 0; i< checkedItems.length; i++){
                            checkedItems[i] = false;
                            mUserItems.clear();
                            selectedAdd.setText("");
                        }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected (MenuItem item){

        /*
        switch (item.getItemId()){
            case R.id.save_add:
                String title = TxTitle.getText().toString().trim();
                String detail = TxDetail.getText().toString().trim();

                //getdate from calendar
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat simpleDate = new SimpleDateFormat("mm, dd, yyyy");
                String created = simpleDate.format(calendar.getTime());

                ContentValues values = new ContentValues();
                values.put(DBHelper.row_title,title);
                values.put(DBHelper.row_note, detail);
                values.put(DBHelper.row_created, created);

                //create  if title and detail is empty

                if(title.equals("") &&  detail.equals("")){
                    Toast.makeText(AddActivity.this,"Nothing To Save", Toast.LENGTH_SHORT).show();
                }
                else{
                    helper.insertData(values);
                    Toast.makeText(AddActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                    finish();
                }

        }
        return onOptionsItemSelected(item);*/

        Intent intent = new Intent(AddActivity.this,MainActivity2.class);
        startActivity(intent);
        return true;
    }
}