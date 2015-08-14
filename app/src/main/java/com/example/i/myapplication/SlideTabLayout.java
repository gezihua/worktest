package com.example.i.myapplication;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

/**
 *
 */
public class SlideTabLayout extends HorizontalScrollView {
    private TabStrip mTabStrip;

    public SlideTabLayout(Context context) {
        this(context, null, 0);
    }

    public SlideTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlideTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 这里需要添加一个LinearLayout
        mTabStrip = new TabStrip(context);
        // 添加布局的宽和高度
        addView(mTabStrip, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        setFillViewport(true);
        // 初始化title的高度
        mTitleHeight = (int) context.getResources().getDisplayMetrics().density * SDEFAULTTITLEHEIGHT;

        // 这里也可以定义在xml去读取高度
        mTitleWidth = (int) context.getResources().getDisplayMetrics().density * sDEFAULTTITLEWIDTH;
        mTabsTitleLayoutParams = new LinearLayout.LayoutParams(mTitleWidth, mTitleHeight);

    }

    /**
     * 这个是下方滑动的View
     * 这个是用控制下边的viewpager
     */
    private ViewPager mViewpager;
    private int mTitleHeight;
    private int mTitleWidth;
    private final static int sDEFAULTTITLEWIDTH = 50;
    private final static int SDEFAULTTITLEHEIGHT = 18;
    private BaseAdapter mTitleAdapter;

    public ViewPager getViewpager() {
        return mViewpager;
    }

    public void setViewpager(ViewPager mViewpager) {
        this.mViewpager = mViewpager;
        mViewpager.setOnPageChangeListener(new InnerPageChangeListener());
    }

    private class InnerPageChangeListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            // scrollto
            scrollToIndexPage(i);
        }


        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }

    private void scrollToIndexPage(int i) {
        if (i >= 0) {
         scrollTo(i*mTitleWidth,0);
        }
    }

    private final LinearLayout.LayoutParams mTabsTitleLayoutParams;

    private void addTabs(View view, int index) {
        //这里需要将view添加到LinearLayout
        if (mTabStrip != null) {
            mTabStrip.addView(view, index, mTabsTitleLayoutParams);
        }
    }

    private void inflateChild() {

        if (mTitleAdapter != null && !mTitleAdapter.isEmpty()) {
            int count = mTitleAdapter.getCount();
            for (int i = 0; i < count; i++) {
                Log.e("inflateChild", i + "");
                final View view = mTitleAdapter.getView(i, null, mTabStrip);
                view.setOnClickListener(new TabOnClickListener(i));
                addTabs(view, i);
            }
        }
        invalidate();
    }

    // 采用baseadapter 作为mStrip的数据存储
    public void setmTitleAdapter(BaseAdapter mTitleAdapter) {
        this.mTitleAdapter = mTitleAdapter;
        inflateChild();
    }

    private class TabOnClickListener implements View.OnClickListener {
        private int position;

        private TabOnClickListener(int p) {
            position = p;
        }

        @Override
        public void onClick(View v) {
            if (v != null && mViewpager != null && position < mViewpager.getAdapter().getCount()) {
                mViewpager.setCurrentItem(position, true);
            }
        }
    }


}
