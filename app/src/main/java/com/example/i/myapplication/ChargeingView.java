package com.example.i.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jason.Su on 2015/8/24.
 */
public class ChargeingView extends View {
    public ChargeingView(Context context) {
        this(context, null, 0);
    }

    public ChargeingView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChargeingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Bitmap mBetteryBitmap = null;

    private void init() {
        mBetteryBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.locker_battery_big_bady);
        mPaint = new Paint();
    }

    private Paint mPaint = null;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mBetteryBitmap != null && !mBetteryBitmap.isRecycled()) {
            canvas.drawBitmap(mBetteryBitmap, 0, 0, mPaint);
        }
    }
}
