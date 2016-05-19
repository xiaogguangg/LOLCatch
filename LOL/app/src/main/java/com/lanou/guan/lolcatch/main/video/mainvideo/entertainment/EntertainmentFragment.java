package com.lanou.guan.lolcatch.main.video.mainvideo.entertainment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;

/**
 * Created by dllo on 16/5/17.
 */
public class EntertainmentFragment extends BaseFragment {
    private RecyclerView recyclerView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_entertainment;
    }

    @Override
    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.entertainment_rv);
    }

    @Override
    protected void initData() {

    }
}
