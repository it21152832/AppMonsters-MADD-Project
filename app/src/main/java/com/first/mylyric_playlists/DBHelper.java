package com.first.mylyric_playlists;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String database_name = "db_playlist";
    public static final String table_name = "table_playlists";

    public static final String row_id = "_id";
    public static final String row_title = "Title";
    public static final String row_note = "Note";
    public static final String row_created = "Created";

    private SQLiteDatabase db;


    public DBHelper(Context context) {
        super(context, database_name, null, 2);
        db = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String query = "CREATE TABLE "+ table_name + "(" + row_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + row_title + " TEXT," + row_note + " TEXT, " + row_created + " TEXT)" ;
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int x) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
    }

    //get all sqlite data
    public Cursor allData(){
        Cursor cur = db.rawQuery("SELECT * FROM "+table_name+" ORDER BY "+row_id+" DESC ", null);
        return cur;
    }

    //get one data by id

    public Cursor oneData(Long id){
        Cursor cur = db.rawQuery("SELECT * FROM " +table_name+ " WHERE " +row_id+ "=" +id, null);
        return cur;
    }

    //insert data

    public void insertData(ContentValues values){

        db.insert(table_name,null, values);
    }

    //update data

    public void updateData(ContentValues values, Long id){
        db.update(table_name,values,row_id+"="+id, null);
    }

    //delete data

    public void deleteData(long id){

        db.delete(table_name,row_id+"="+id, null);
    }
}
