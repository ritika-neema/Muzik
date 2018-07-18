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

/**
 * Created by uswer on 7/17/2018.
 */

public class ListViewAdapter extends ArrayAdapter<Album> {
    public ListViewAdapter(@NonNull Context context, ArrayList<Album> songs) {
        super(context, 0, songs);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list, parent, false);
        }

        Album song = getItem(position);
        TextView songTextView = listItemView.findViewById(R.id.text_song);
        songTextView.setText(song.getmSongName());
        TextView artistTextView = listItemView.findViewById(R.id.text_artist);
        artistTextView.setText(song.getmArtistName());
        ImageView songImageView = listItemView.findViewById(R.id.image_album);
        songImageView.setImageResource(song.getmImageview_resID());
        return listItemView;

    }
}
