package com.example.i.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jason.Su on 2015/8/14.
 */
public class SimpleFragment extends Fragment {
    private String content;

    public SimpleFragment() {
        content = "null";
    }

    public SimpleFragment(String content) {
        super();
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (inflater != null) {
            final View view = inflater.inflate(R.layout.fragment_layout, null, false);
            ((TextView) (view.findViewById(R.id.fragment_text))).setText(content);
            return view;
        }
        return null;
    }
}
