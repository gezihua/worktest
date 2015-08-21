package com.example.i.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by Jason.Su on 2015/8/14.
 */
public class TabStrip extends LinearLayout {
    private Paint mSelectedIndicatorPaint;

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
        mSelectedIndicatorPaint = new Paint();
    }

    private int mSelectionTitle = 0;
    private final int mSelectedIndicatorThickness = 10;

    public void updateHintLine(int select) {
        mSelectionTitle = select;
        postInvalidate();
    }

    private final static int sColor = Color.BLUE;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int height = getHeight();
        if (mSelectionTitle >= 0) {
            final View view = getChildAt(mSelectionTitle);
            int start = view.getLeft();
            int end = view.getRight();
            canvas.drawRect(start, height - mSelectedIndicatorThickness, end,
                    height, mSelectedIndicatorPaint);
        }
    }
}
