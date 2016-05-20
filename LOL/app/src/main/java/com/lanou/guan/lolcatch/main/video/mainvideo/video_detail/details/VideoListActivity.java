package com.lanou.guan.lolcatch.main.video.mainvideo.video_detail.details;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseActivity;
import com.lanou.guan.lolcatch.main.base.GsonRequest;
import com.lanou.guan.lolcatch.main.base.MyClickListener;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/19.
 */
public class VideoListActivity extends BaseActivity implements MyClickListener{
    private int pos;
    //private MyBroadCast myBroadCast;
    private ImageView imageView;
    private TextView titleTv;
    private TextView articleTv;
    private RecyclerView recyclerView;
    private VideoDetailBean bean;
    private VideoListAdapter atvAdapter;
    private  String id;
    private String url;
    private String title;
    private String article;
    private String videoUrl;
    String abc;
    private Intent intent;

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        super.addContentView(view, params);
    }

    @Override
    public int initLayout() {
        return R.layout.activity_entertainment;
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.entertainment_aty_rv);
        imageView = (ImageView) findViewById(R.id.entertainment_title_iv);
        titleTv = (TextView) findViewById(R.id.entertainment_title_tv);
        articleTv = (TextView) findViewById(R.id.entertainment_article_tv);
        intent = getIntent();
        id = intent.getStringExtra("id");
        url = intent.getStringExtra("imageurl");
        title = intent.getStringExtra("titleTv");
        article = intent.getStringExtra("article");
        abc = "http://lol.zhangyoubao.com/apis/rest/ItemsService/videos?catwordid="+id+"&page=1&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438760163&p_=2834&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol";

    }

    @Override
    public void initData() {
        initResponse();
        atvAdapter = new VideoListAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(atvAdapter);
        atvAdapter.setClickListener(this);
        titleTv.setText(title);
        articleTv.setText(article);
        Picasso.with(this).load(url).into(imageView);


    }
    public void initResponse(){
        RequestQueue queue = Volley.newRequestQueue(this);
        GsonRequest<VideoDetailBean> request = new GsonRequest<>(com.android.volley.Request.Method.GET,abc,new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<VideoDetailBean>() {
            @Override
            public void onResponse(VideoDetailBean response) {
                bean = response;
                atvAdapter.setBean(bean);
            }
        },VideoDetailBean.class);
        queue.add(request);
    }

    @Override
    public void OnClick(int pos) {
        intent = new Intent(this,VideoDetailActivity.class);
        videoUrl = bean.getData().get(pos).getVideo_url();
        intent.putExtra("videoUrl",videoUrl);
        startActivity(intent);
    }
}
