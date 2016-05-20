package com.lanou.guan.lolcatch.main.video.mainvideo.entertainment.details;

import android.content.Intent;
import android.net.Uri;
import android.widget.VideoView;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseActivity;

/**
 * Created by dllo on 16/5/19.
 */
public class VideoDetailActivity extends BaseActivity {
    private VideoView videoView;
    private Intent intent;
    private String videoUrl;

    @Override
    public int initLayout() {
        return R.layout.activity_detail_video;
    }

    @Override
    public void initView() {
        videoView = (VideoView) findViewById(R.id.video_detail_vv);
        intent = getIntent();
        videoUrl = intent.getStringExtra("videoUrl");
    }

    @Override
    public void initData() {
        initVideo();
    }

    private void initVideo() {
        videoView.setVideoURI(Uri.parse(videoUrl));
        videoView.setMediaController(new android.widget.MediaController(this));
        videoView.start();
    }

}
