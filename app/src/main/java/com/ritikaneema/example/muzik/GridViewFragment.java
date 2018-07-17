package com.ritikaneema.example.muzik;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static com.ritikaneema.example.muzik.MainActivity.main_view;

public class GridViewFragment extends Fragment {

    private View rootview;
    private ArrayList<Album> localSong;

    private boolean paused = false;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_gridview, null);
        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        localSong = new ArrayList<Album>();
        localSong.add(new Album("Z-Chota sa fasana", "Arijit Singh", R.drawable.album));
        localSong.add(new Album("Z-Chota sa fasana", "Arijit Singh", R.drawable.album));
        localSong.add(new Album("Z-Chota sa fasana", "Arijit Singh", R.drawable.album));
        localSong.add(new Album("Z-Chota sa fasana", "Arijit Singh", R.drawable.album));
        localSong.add(new Album("Z-Chota sa fasana", "Arijit Singh", R.drawable.album));

        getSongList();

        Collections.sort(localSong, new Comparator<Album>() {
            public int compare(Album a, Album b) {
                return a.getmSongName().compareTo(b.getmSongName());
            }
        });

        AlbumAdapter song = new AlbumAdapter(rootview.getContext(), localSong);
        GridView gridView = rootview.findViewById(R.id.grid_view_layout);
        gridView.setAdapter(song);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar snackbar = Snackbar
                        .make(main_view, localSong.get(position).getmSongName(), Snackbar.LENGTH_INDEFINITE)
                        .setAction("Playing", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try {
                                    Intent intent = new Intent(main_view.getContext(), NowPlayingActivity.class);
                                    startActivity(intent);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        });

                View snackbarLayout = snackbar.getView();
                FrameLayout.LayoutParams parentParams = (FrameLayout.LayoutParams) snackbarLayout.getLayoutParams();
                parentParams.setMargins(0, 0, 0, 148);
                snackbarLayout.setLayoutParams(parentParams);
                TextView textView = (TextView) snackbarLayout.findViewById(android.support.design.R.id.snackbar_text);
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_outline_play_circle_filled_white_24px, 0);
                textView.setCompoundDrawablePadding(getResources().getDimensionPixelOffset(R.dimen.padding8));
                snackbar.show();
            }
        });


    }

    public void getSongList() {
        //retrieve song info
        ContentResolver musicResolver = rootview.getContext().getContentResolver();
        Uri musicUri = android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);
        if (musicCursor != null && musicCursor.moveToFirst()) {
            //get columns
            int titleColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.TITLE);
            int idColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media._ID);
            int artistColumn = musicCursor.getColumnIndex
                    (android.provider.MediaStore.Audio.Media.ARTIST);
            //add songs to list
            do {
                long thisId = musicCursor.getLong(idColumn);
                String thisTitle = musicCursor.getString(titleColumn);
                String thisArtist = musicCursor.getString(artistColumn);
                localSong.add(new Album(thisId, thisTitle, thisArtist, R.drawable.ic_outline_play_circle_filled_white_24px));
            }
            while (musicCursor.moveToNext());
        }
    }

}
