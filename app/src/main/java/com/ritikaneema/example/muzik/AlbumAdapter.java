package com.ritikaneema.example.muzik;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AlbumAdapter extends ArrayAdapter<Album> {

    public AlbumAdapter(@NonNull Context context, ArrayList<Album> songs) {
        super(context, 0,  songs);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View gridItemView = convertView;

        if(gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.gridview_cards, parent, false);
        }

        Album currentSong  =  getItem(position);

        TextView songTextView = gridItemView.findViewById(R.id.text_song_name);

        /**songTextView represents song name in Favorites and Home fragment
         and playlist name in Playlist fragment where getmSongName() should return null**/
        if (currentSong.getmSongName() != null)
        songTextView.setText(currentSong.getmSongName());
        else songTextView.setText(currentSong.getmPlaylistName());

        TextView artistTextView =  gridItemView.findViewById(R.id.text_artist_name);
        artistTextView.setText(currentSong.getmArtistName());

        ImageView songImageView =  gridItemView.findViewById(R.id.imageview_album);
        songImageView.setImageResource(currentSong.getmImageview_resID());

        return gridItemView;

    }
}
