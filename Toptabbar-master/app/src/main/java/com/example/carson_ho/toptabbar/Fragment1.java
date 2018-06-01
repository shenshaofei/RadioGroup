package com.example.carson_ho.toptabbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.carson_ho.toptabbar.shrink.ExpandView;

/**
 * Created by Carson_Ho on 16/7/22.
 */
public class Fragment1 extends Fragment {

    private ViewGroup mRootView;
    private LinearLayout lin_tv;
    private ImageView img_shrink;
    private ExpandView expandView;
    private TextView textview_title;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mRootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);

        initView();
        ExpandView();
        return mRootView;

    }
    /**
     * 初始化控件
     */
    private void initView() {
        lin_tv = (LinearLayout) mRootView.findViewById(R.id.lin_tv);
        img_shrink = (ImageView) mRootView.findViewById(R.id.img_shrink);
        expandView = (ExpandView) mRootView.findViewById(R.id.ex_expandview);
        textview_title = (TextView) mRootView.findViewById(R.id.textview_title);
    }

    /**
     * 初始化调用
     */
    public void ExpandView() {
        expandView.setContentView();
        lin_tv.setClickable(true);
        lin_tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (expandView.isExpand()) {
                    expandView.collapse();
                    textview_title.setText("点击向下展开");
                    img_shrink.setImageDrawable(getResources().getDrawable(R.mipmap.open));
                } else {
                    expandView.expand();
                    textview_title.setText("点击向上收缩");
                    img_shrink.setImageDrawable(getResources().getDrawable(R.mipmap.close));
                }
            }
        });
    }

}
