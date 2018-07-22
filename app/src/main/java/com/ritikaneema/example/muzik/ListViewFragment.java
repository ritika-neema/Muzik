package com.ritikaneema.example.muzik;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

import static com.ritikaneema.example.muzik.MainActivity.main_view;


/**
 * Created by uswer on 7/17/2018.
 */

public class ListViewFragment extends Fragment {

    private View rootview;
    private ArrayList<Album> songs;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_listview, null);
        return rootview;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        songs = new ArrayList<Album>();

        songs.add(new Album(getString(R.string.title), getString(R.string.artist), R.drawable.album));
        songs.add(new Album(getString(R.string.title), getString(R.string.artist), R.drawable.album));
        songs.add(new Album(getString(R.string.title), getString(R.string.artist), R.drawable.album));
        songs.add(new Album(getString(R.string.title), getString(R.string.artist), R.drawable.album));
        songs.add(new Album(getString(R.string.title), getString(R.string.artist), R.drawable.album));
        songs.add(new Album(getString(R.string.title), getString(R.string.artist), R.drawable.album));
        songs.add(new Album(getString(R.string.title), getString(R.string.artist), R.drawable.album));
        songs.add(new Album(getString(R.string.title), getString(R.string.artist), R.drawable.album));
        songs.add(new Album(getString(R.string.title), getString(R.string.artist), R.drawable.album));
        songs.add(new Album(getString(R.string.title), getString(R.string.artist), R.drawable.album));

        ListViewAdapter song = new ListViewAdapter(rootview.getContext(), songs);
        ListView listView = rootview.findViewById(R.id.listview_songs);
        listView.setAdapter(song);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar snackbar = Snackbar
                        .make(main_view, songs.get(position).getmSongName(), Snackbar.LENGTH_INDEFINITE)
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
                snackbar.show();
            }
        });
    }
}
