package com.example.i.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Jason.Su on 2015/8/3.
 */
public class SwipeItemLayout extends FrameLayout implements View.OnTouchListener {

    public SwipeItemLayout(Context context) {
        this(context, null, 0);
    }

    public SwipeItemLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private String mOpenText;
    private String mClosedText;
    private Paint mPaint;

    private void init() {
        mOpenText = "open";
        mClosedText = "closed";
        mPaint = new Paint();
        setOnTouchListener(this);
    }

    public SwipeItemLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mFont = getChildAt(0);
    }

    private float mStartX;
    private float mStartY;


    private View mFont;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas != null) {
            canvas.drawText(mOpenText, mStartX, mStartY, mPaint);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_MOVE:{
                mStartX= event.getRawX();
                mStartY = event.getRawY();
                break;
            }
        }
        invalidate();
        return false;
    }
}
