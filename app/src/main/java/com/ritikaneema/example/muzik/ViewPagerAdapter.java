package com.ritikaneema.example.muzik;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by uswer on 4/14/2018.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;


    private int[] images = {R.drawable.placeholder1, R.drawable.placeholder2,
            R.drawable.placeholder3, R.drawable.placeholder4};


    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.custom_layout, null);

        ImageView imageView = view.findViewById(R.id.imageViewFeature);
        imageView.setImageResource(images[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);

        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        Toast.makeText(view.getContext(), "Latest Hindi Songs, Coming Soon", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(view.getContext(), "Latest English Songs, Coming Soon", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(view.getContext(), "Hindi Song Artists, Coming Soon", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(view.getContext(), "English Song Artists, Coming Soon", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }


}
