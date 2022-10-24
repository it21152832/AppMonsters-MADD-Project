package com.example.userlogin.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyLyric.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_QUERY = "CREATE TABLE " + RequestMaster.Request.TABLE_NAME + " ("+
                RequestMaster.Request._ID + " INTEGER PRIMARY KEY," +
                RequestMaster.Request.COLUMN_NAME_NAME + " TEXT,"+
                RequestMaster.Request.COLUMN_NAME_SONG + " TEXT,"+
                RequestMaster.Request.COLUMN_NAME_TYPE + " TEXT)";

        sqLiteDatabase.execSQL(SQL_CREATE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

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

    public boolean login(Request r){
        SQLiteDatabase db = getReadableDatabase();
        long id = 0;

        //select id from users where username = " " and password = " "
        String[] projection = {
                RequestMaster.Request._ID,
                RequestMaster.Request.COLUMN_NAME_NAME,
                RequestMaster.Request.COLUMN_NAME_SONG,
                RequestMaster.Request.COLUMN_NAME_NAME
        };

        String selection = RequestMaster.Request.COLUMN_NAME_NAME + " LIKE ? AND " + RequestMaster.Request.COLUMN_NAME_SONG + " LIKE ? AND "
                + RequestMaster.Request.COLUMN_NAME_TYPE + " LIKE ? ";

        String selectionArgs[] = {
                r.getArtist_name(),
                r.getSong_title(),
                r.getSong_type()
        };

        String sortOrder = RequestMaster.Request.COLUMN_NAME_NAME + " DESC ";

        Cursor c = db.query(
                RequestMaster.Request.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder

        );

        while (c.moveToNext()){
            id = c.getLong(c.getColumnIndexOrThrow(RequestMaster.Request._ID));
        }

        if(id > 0){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean editRequest(Request u){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(RequestMaster.Request.COLUMN_NAME_TYPE , u.getSong_type());

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
                        u.getArtist_name()
                }
        );

        if(count > 0){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean deleteRequest(Request u){
        SQLiteDatabase db = getReadableDatabase();

        if (db.delete(
                RequestMaster.Request.TABLE_NAME,
                RequestMaster.Request.COLUMN_NAME_NAME + " = ? ",
                new String[]{
                        u.getArtist_name()
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
