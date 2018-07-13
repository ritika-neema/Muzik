package com.ritikaneema.example.muzik;

public class Album {

    private String mSongName;
    private String mArtistName;
    private String mPlaylistName;
    private int mImageview_resID;

    public Album(String songName, String artistName, int imageview_resID) {
        mSongName = songName;
        mArtistName = artistName;
        mImageview_resID = imageview_resID;
    }

    public String getmSongName() {return mSongName;}

    public String getmArtistName() {return mArtistName;}

    public String getmPlaylistName() {
        return mPlaylistName;
    }

    public int getmImageview_resID() {
        return mImageview_resID;
    }

}
