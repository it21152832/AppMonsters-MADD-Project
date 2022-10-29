package com.example.userlogin.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "RequestInfo.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE request(id INTEGER primary key,artist_name TEXT, song_title TEXT, song_type TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists request");
    }

    public long AddInfo(Request r){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(RequestMaster.Request.COLUMN_NAME_NAME, r.getArtist_name());
        cv.put(RequestMaster.Request.COLUMN_NAME_SONG, r.getSong_title());
        cv.put(RequestMaster.Request.COLUMN_NAME_TYPE, r.getSong_type());

        long i = db.insert(RequestMaster.Request.TABLE_NAME, null , cv);

        return i;

    }


    public boolean updateUser(Request r){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(RequestMaster.Request.COLUMN_NAME_SONG, r.getSong_title());

        /*
        String selection = UsersMaster.Users.COLUMN_NAME_USERNAME = " LIKE ? ";
        String[] selectArgs = {
                u.getUsername()
        };
        **/

        int count = db.update(
                RequestMaster.Request.TABLE_NAME,
                values,
                RequestMaster.Request.COLUMN_NAME_NAME + " LIKE ? ",
                new String[]{
                        r.getArtist_name()

                }
        );

        if(count > 0){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean deleteUser(Request r){
        SQLiteDatabase db = getReadableDatabase();

        if (db.delete(
                RequestMaster.Request.TABLE_NAME,
                RequestMaster.Request.COLUMN_NAME_NAME + " = ? ",
                new String[]{
                        r.getArtist_name()
                } ) > 0
        )
        {
            return true;
        }
        else{
            return false;
        }

    }
}
