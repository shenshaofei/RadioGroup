package com.example.carson_ho.toptabbar.shrink;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.example.carson_ho.toptabbar.R;

/**
 * Created by v_shenshaofei on 2018/5/31.
 */

/**
 * 收缩控件
 */
public class ExpandView extends FrameLayout implements View.OnClickListener {

    private Animation mExpandAnimation;
    private Animation mCollapseAnimation;
    private boolean mIsExpand;

    public ExpandView(Context context) {
        this(context, null);
    }

    public ExpandView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExpandView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initExpandView();
    }

    private void initExpandView() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_expand, this, true);

//        mExpandAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.expand);
        mExpandAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_fade_out);
        mExpandAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                setVisibility(View.VISIBLE);
            }
        });

        mCollapseAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_fade_in);
        mCollapseAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                setVisibility(View.GONE);
            }
        });

    }

    public void collapse() {
        if (mIsExpand) {
            mIsExpand = false;
            clearAnimation();
            startAnimation(mCollapseAnimation);
        }
    }

    public void expand() {
        if (!mIsExpand) {
            mIsExpand = true;
            clearAnimation();
            startAnimation(mExpandAnimation);
        }
    }

    public boolean isExpand() {
        return mIsExpand;
    }
    public void setContentView() {
        View view = null;
        view = LayoutInflater.from(getContext()).inflate(R.layout.layout_expand, null);
        removeAllViews();
        addView(view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }
    }
}

