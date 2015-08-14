package com.example.i.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Jason.Su on 2015/8/4.
 */
public class ExtendableTextView extends LinearLayout implements View.OnClickListener {

    private Button mExtendsRotate;
    private TextView mEXtendsText;

    public ExtendableTextView(Context context) {
        this(context, null);
    }

    public ExtendableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, 0);
        init();
    }

    private boolean mExtendsRotateUp = true;



    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.extends_layout,null,false);
        addView(view);
        setOrientation(VERTICAL);
        mExtendsRotate = (Button) view.findViewById(R.id.extendable_btn);
        mEXtendsText = (TextView)view.findViewById(R.id.extendable_text);
        mExtendsRotate.setOnClickListener(this);
    }

    public ExtendableTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    @Override
    public void onClick(View v) {
        if (mExtendsRotateUp) {
            mExtendsRotate.setBackgroundResource(R.drawable.ic_collapse_small_holo_light);
        } else {
            mExtendsRotate.setBackgroundResource(R.drawable.ic_expand_small_holo_light);
        }
        mExtendsRotateUp = !mExtendsRotateUp;
    }

}
