package com.lanou.guan.lolcatch.main.video.mainvideo.mainvideo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.video.mainvideo.comment.CommentFragment;
import com.lanou.guan.lolcatch.main.video.mainvideo.entertainment.EntertainmentFragment;
import com.lanou.guan.lolcatch.main.video.mainvideo.game.GameFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/17.
 */
public class VideoFragment extends BaseFragment {
    private List<BaseFragment> baseFragments;
    private ViewPager videoVp;
    private TabLayout videotb;
    private VideoAdapter videoAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView(View view) {
        videoVp = (ViewPager) view.findViewById(R.id.video_vp);
        videotb = (TabLayout) view.findViewById(R.id.video_tb);
    }

    @Override
    protected void initData() {
        initFragment();
        videoAdapter = new VideoAdapter(getFragmentManager());
        videoAdapter.setBaseFragments(baseFragments);
        videoVp.setAdapter(videoAdapter);
        videotb.setupWithViewPager(videoVp);

    }
    public void initFragment(){
        baseFragments = new ArrayList<>();
        baseFragments.add(new EntertainmentFragment());
        baseFragments.add(new CommentFragment());
        baseFragments.add(new GameFragment());
    }
}
