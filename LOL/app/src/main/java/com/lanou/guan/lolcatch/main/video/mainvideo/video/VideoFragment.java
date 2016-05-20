package com.lanou.guan.lolcatch.main.video.mainvideo.video;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.base.GsonRequest;
import com.lanou.guan.lolcatch.main.base.URLTool;
import com.lanou.guan.lolcatch.main.video.mainvideo.video_detail.VideoBean;
import com.lanou.guan.lolcatch.main.video.mainvideo.video_detail.VideoDetailFragment;

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
    private VideoBean bean;

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

    public void initResponse(){
        RequestQueue requestQueue = Volley.newRequestQueue(this.context);
        GsonRequest<VideoBean> request = new GsonRequest<VideoBean>(com.android.volley.Request.Method.GET, URLTool.VIDEO_COMMENT, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<VideoBean>() {
            @Override
            public void onResponse(VideoBean response) {
                bean = response;
            }
        },VideoBean.class);
        requestQueue.add(request);
    }
    public void initFragment(){
        baseFragments = new ArrayList<>();
        baseFragments.add(new VideoDetailFragment(0));
        baseFragments.add(new VideoDetailFragment(1));
        baseFragments.add(new VideoDetailFragment(2));
    }
}
