package com.example.i.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * Created by Yanjiao .su on 2015/7/30.
 */
public class AbsScollView extends ViewGroup implements View.OnTouchListener {
    private Scroller mScroller;

    public AbsScollView(Context context) {
        super(context);
        init();
    }

    public AbsScollView(Context context, AttributeSet attrs) {
        this(context);
    }

    public AbsScollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
    }

    private void init() {
        setOnTouchListener(this);
        mScroller = new Scroller(getContext(),new ScrollInterpolator());
    }
    private static class ScrollInterpolator implements Interpolator {
        public ScrollInterpolator() {
        }

        public float getInterpolation(float t) {
            t -= 1.0f;
            return t*t*t*t*t + 1;
        }
    }


    @Override
    protected void dispatchDraw(Canvas canvas) {
        Log.e("Jason", "dispatchDraw");
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("Jason", "onDraw");
    }

    /**
     * 100*200
     *
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            int top = i * 100;
            int bottom = (i + 1) * 100;
            getChildAt(i).layout(mLastPosX, top, mLastPosX+100, bottom);
        }

        Log.e("Jason","call onLayout");
    }

    // 因为这个是横向移动，所以 Y值不变，X 进行变化
    private int mScollX = 0;
    private int mLastPosX = 0;
    private int mActionDownX = 0;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN: {
                mActionDownX = (int) event.getRawX();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int temp = (int) event.getRawX();
                mScollX = mActionDownX-temp;
                mActionDownX = temp;
                scrollBy(mScollX,0);
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
        }
        return true;
    }

    @Override
    protected boolean drawChild(Canvas canvas, View child, long drawingTime) {
        return super.drawChild(canvas, child, drawingTime);
    }
}
