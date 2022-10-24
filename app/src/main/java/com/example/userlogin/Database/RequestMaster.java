package com.example.userlogin.Database;

import android.provider.BaseColumns;

public final class RequestMaster {

    private RequestMaster() {

    }

    //inner class
    public static class Request implements BaseColumns{
        public static final String TABLE_NAME = "request";
        public static String COLUMN_NAME_NAME = "artist_name";
        public static final String COLUMN_NAME_SONG = "song_title";
        public static final String COLUMN_NAME_TYPE = "song_type";

    }
}
