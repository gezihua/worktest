package com.example.i.myapplication.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

import com.example.i.myapplication.R;

/**
 * Created by Jason.Su on 2015/9/24.
 */
public class BitmapFrame {

    private Context mContext;

    public BitmapFrame(Context context) {
        mContext = context;
    }

    public AnimationDrawable getAnimationDrawable() {
        AnimationDrawable drawable = new AnimationDrawable();
        BitmapDrawable drawable1 = new BitmapDrawable(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_collapse_small_holo_light));
        drawable.addFrame(drawable1, 0);
        drawable1 = new BitmapDrawable(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_expand_small_holo_light));
        drawable.addFrame(drawable1, 1);
        return drawable;
    }

}
