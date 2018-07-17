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
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.ritikaneema.example.muzik.MainActivity.main_view;

/**
 * Created by uswer on 7/12/2018.
 */

public class FavoritesFragment extends Fragment {
    private View rootview;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootview = inflater.inflate(R.layout.fragment_gridview, null);

        return rootview;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final ArrayList<Album> localSon = new ArrayList<Album>();
        localSon.add(new Album("Soorma Anthem", "Shankar Mahadevan", R.drawable.album));
        localSon.add(new Album("Soorma Anthem", "Shankar Mahadevan", R.drawable.album));
        localSon.add(new Album("Soorma Anthem", "Shankar Mahadevan", R.drawable.album));
        localSon.add(new Album("Soorma Anthem", "Shankar Mahadevan", R.drawable.album));
        localSon.add(new Album("Soorma Anthem", "Shankar Mahadevan", R.drawable.album));
        localSon.add(new Album("Soorma Anthem", "Shankar Mahadevan", R.drawable.album));
        localSon.add(new Album("Soorma Anthem", "Shankar Mahadevan", R.drawable.album));
        localSon.add(new Album("Soorma Anthem", "Shankar Mahadevan", R.drawable.album));
        localSon.add(new Album("Soorma Anthem", "Shankar Mahadevan", R.drawable.album));

        AlbumAdapter song = new AlbumAdapter(rootview.getContext(), localSon);
        GridView gridView = rootview.findViewById(R.id.grid_view_layout);
        gridView.setAdapter(song);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar snackbar = Snackbar
                        .make(main_view, localSon.get(position).getmSongName(), Snackbar.LENGTH_INDEFINITE)
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
}
