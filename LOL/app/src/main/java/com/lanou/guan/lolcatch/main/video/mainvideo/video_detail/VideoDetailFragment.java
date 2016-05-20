package com.lanou.guan.lolcatch.main.video.mainvideo.video_detail;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.base.MyClickListener;
import com.lanou.guan.lolcatch.main.base.URLTool;
import com.lanou.guan.lolcatch.main.base.VolleySingle;
import com.lanou.guan.lolcatch.main.video.mainvideo.video_detail.details.VideoListActivity;

/**
 * Created by dllo on 16/5/17.
 */
public class VideoDetailFragment extends BaseFragment implements MyClickListener {
    private RecyclerView recyclerView;
    VideoDetailAdapter entertainmentAdapter;
    private VideoBean bean;
    private Intent intent;
    private int pos;

    public VideoDetailFragment(int pos) {
        this.pos = pos;
    }

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
        initResponse();
        entertainmentAdapter = new VideoDetailAdapter(this.context);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        recyclerView.setAdapter(entertainmentAdapter);
        recyclerView.setHasFixedSize(true);
        entertainmentAdapter.setClickListener(this);
        entertainmentAdapter.setPos(pos);
    }

    public void initResponse() {
        VolleySingle.addRequest(URLTool.VIDEO_COMMENT, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<VideoBean>() {
            @Override
            public void onResponse(VideoBean response) {
                bean = response;
                entertainmentAdapter.setBean(bean);
            }
        }, VideoBean.class);
    }


    @Override
    public void OnClick(int position) {
        intent = new Intent(this.context, VideoListActivity.class);
        String id = bean.getData().get(pos).getCatword_id().get(position).getId();
        String url = bean.getData().get(pos).getCatword_id().get(position).getPic_url();
        String title = bean.getData().get(pos).getCatword_id().get(position).getName();
        String article = bean.getData().get(pos).getCatword_id().get(position).getDesc();
        intent.putExtra("imageurl" , url);
        intent.putExtra("titleTv" , title);
        intent.putExtra("article" , article);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public VideoBean getData() {
        return bean;
    }
}
