package com.example.mylyric.Database;

public class Request {
    private Integer requestID;
    private String artist_name;
    private String song_title;
    private String song_type;

    public Request(String artist_name, String song_title, String song_type) {
        this.artist_name = artist_name;
        this.song_title = song_title;
        this.song_type = song_type;
    }

    public Integer getRequestID() {
        return requestID;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public String getSong_title() {
        return song_title;
    }

    public String getSong_type() {
        return song_type;
    }
}
