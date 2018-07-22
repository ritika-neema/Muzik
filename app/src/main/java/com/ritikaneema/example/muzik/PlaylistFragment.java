package com.ritikaneema.example.muzik;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by uswer on 7/12/2018.
 */

public class PlaylistFragment extends Fragment {
    private View rootview;

    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_gridview, null);
        ArrayList<Album> playlists = new ArrayList<Album>();
        playlists.add(new Album("Delight", R.drawable.album));
        playlists.add(new Album("EDM", R.drawable.album));
        playlists.add(new Album("Romantic", R.drawable.album));
        playlists.add(new Album("Shared", R.drawable.album));
        playlists.add(new Album("Nostalgiac", R.drawable.album));
        playlists.add(new Album("Travel", R.drawable.album));
        playlists.add(new Album("Sufi", R.drawable.album));

        AlbumAdapter song = new AlbumAdapter(rootview.getContext(), playlists);
        GridView gridView = rootview.findViewById(R.id.grid_view_layout);
        gridView.setAdapter(song);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new ListViewFragment())
                        .addToBackStack("B")
                        .commit();
                inflater.inflate(R.layout.fragment_listview, null);
            }
        });
        return rootview;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
