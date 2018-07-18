package com.ritikaneema.example.muzik;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private static final int STORAGE_PERMISSIONS_REQUEST = 1;
    public static View main_view;
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //loading the default fragment
        loadFragment(new HomeFragment());

        //getting bottom navigation view and attaching the listener
        navigation = findViewById(R.id.navigationView);
        navigation.setOnNavigationItemSelectedListener(this);

        main_view = navigation.getRootView();

        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSIONS_REQUEST);
            }
        } else {
            //permission is automatically granted on sdk<23 upon installation
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.navigation_home:
                navigation.getMenu().getItem(0).setIcon(R.drawable.ic_baseline_home_24px);
                navigation.getMenu().getItem(1).setIcon(R.drawable.ic_outline_favorite_border_24px);
                navigation.getMenu().getItem(2).setIcon(R.drawable.ic_outline_play_circle_filled_white_24px);
                fragment = new HomeFragment();
                break;

            case R.id.navigation_favorites:
                navigation.getMenu().getItem(0).setIcon(R.drawable.ic_outline_home_24px);
                navigation.getMenu().getItem(1).setIcon(R.drawable.ic_outline_favorite_24px);
                navigation.getMenu().getItem(2).setIcon(R.drawable.ic_outline_play_circle_filled_white_24px);
                fragment = new FavoritesFragment();
                break;

            case R.id.navigation_playlist:
                navigation.getMenu().getItem(0).setIcon(R.drawable.ic_outline_home_24px);
                navigation.getMenu().getItem(1).setIcon(R.drawable.ic_outline_favorite_border_24px);
                navigation.getMenu().getItem(2).setIcon(R.drawable.ic_baseline_play_circle_filled_24px);
                fragment = new PlaylistFragment();
                break;
        }

        return loadFragment(fragment);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case STORAGE_PERMISSIONS_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay!
                } else {
                    Toast.makeText(getBaseContext(), "The app require storage permission to run", Toast.LENGTH_SHORT).show();
                }

            }
            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

}
