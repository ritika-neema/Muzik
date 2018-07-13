package com.ritikaneema.example.muzik;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by uswer on 7/13/2018.
 */

public class GridViewFragment extends Fragment {

    private View rootview;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_gridview, null);
        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<Album> localSong = new ArrayList<Album>();
        localSong.add(new Album("Chota sa fasana", "Arijit Singh", R.drawable.ic_outline_favorite_24px));
        localSong.add(new Album("Chota sa fasana", "Arijit Singh", R.drawable.ic_outline_favorite_24px));
        localSong.add(new Album("Chota sa fasana", "Arijit Singh", R.drawable.ic_outline_favorite_24px));
        localSong.add(new Album("Chota sa fasana", "Arijit Singh", R.drawable.ic_outline_favorite_24px));
        localSong.add(new Album("Chota sa fasana", "Arijit Singh", R.drawable.ic_outline_favorite_24px));
        localSong.add(new Album("Chota sa fasana", "Arijit Singh", R.drawable.ic_outline_favorite_24px));
        localSong.add(new Album("Chota sa fasana", "Arijit Singh", R.drawable.ic_outline_favorite_24px));
        localSong.add(new Album("Chota sa fasana", "Arijit Singh", R.drawable.ic_outline_favorite_24px));
        localSong.add(new Album("Chota sa fasana", "Arijit Singh", R.drawable.ic_outline_favorite_24px));


        AlbumAdapter song = new AlbumAdapter(getContext(),localSong);
        GridView gridView = rootview.findViewById(R.id.grid_view_layout);
        gridView.setAdapter(song);
    }
}
