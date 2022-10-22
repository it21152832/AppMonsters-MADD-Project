package com.example.userlogin.ui;

import java.util.ArrayList;
import java.util.List;

public class Request {

    public static List<RequestType> getRequestTypeList(){
        List<RequestType> list = new ArrayList<>();

        RequestType None = new RequestType();
        None.setName("None");
        list.add(None);

        RequestType Songs = new RequestType();
        Songs.setName("Songs");
        list.add(Songs);

        RequestType Lyrics = new RequestType();
        Lyrics.setName("Lyrics");
        list.add(Lyrics);

        return list;
    }
}
