package com.example.i.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;

/**
 * Created by Jason.Su on 2015/8/14.
 */
public class TabStrip extends LinearLayout {
    public TabStrip(Context context) {
        this(context, null, 0);
    }

    public TabStrip(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TabStrip(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        setBackgroundColor(Color.WHITE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
