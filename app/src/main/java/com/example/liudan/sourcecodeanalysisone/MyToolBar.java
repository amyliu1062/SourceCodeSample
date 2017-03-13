package com.example.liudan.sourcecodeanalysisone;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by liudan on 2017/3/10.
 */

public class MyToolBar extends Toolbar {

    private TextView mTitleTextView;

    public MyToolBar(Context context) {
        super(context);
    }

    public MyToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        if (mTitleTextView != null) {
            mTitleTextView.setText(title);
        }
    }

    public void setTitleTextView(TextView mTitleTextView) {
        this.mTitleTextView = mTitleTextView;
        this.mTitleTextView.setText(getTitle());
    }
}
