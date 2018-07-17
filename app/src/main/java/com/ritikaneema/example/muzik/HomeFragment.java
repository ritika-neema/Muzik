package com.ritikaneema.example.muzik;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by uswer on 7/12/2018.
 */

public class HomeFragment extends Fragment {

    public int autoslideTracker;
    public ViewPager viewPager;
    LinearLayout sliderDotspanel;
    int dotscount;
    ImageView[] dots;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getChildFragmentManager().beginTransaction()
                .add(R.id.gridview_container, new GridViewFragment())
                .addToBackStack("B")
                .commit();
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        viewPager = (ViewPager) getView().findViewById(R.id.viewPager);
        sliderDotspanel = (LinearLayout) getView().findViewById(R.id.SliderDots);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];
        for (int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.tab_indicator_default));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.tab_indicator_selected));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotscount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.tab_indicator_default));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.tab_indicator_selected));

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 500, 1000);


        super.onViewCreated(view, savedInstanceState);
    }


    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            if (isVisible()) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (autoslideTracker <= 3) {
                            if (isVisible() && viewPager.getCurrentItem() == 0) {
                                viewPager.setCurrentItem(1);
                                autoslideTracker++;
                            } else if (isVisible() && viewPager.getCurrentItem() == 1) {
                                viewPager.setCurrentItem(2);
                                autoslideTracker++;
                            } else if (isVisible() && viewPager.getCurrentItem() == 2) {
                                viewPager.setCurrentItem(3);
                                autoslideTracker++;
                            } else if (isVisible() && viewPager.getCurrentItem() == 3) {
                                viewPager.setCurrentItem(0);
                                autoslideTracker++;
                            }
                        }
                    }
                });
            }
        }
    }
}
