package com.lanou.guan.lolcatch.main.video.mainvideo.entertainment;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.base.GsonRequest;
import com.lanou.guan.lolcatch.main.base.URLTool;
import com.lanou.guan.lolcatch.main.video.mainvideo.entertainment.details.EntertainmentActivity;

/**
 * Created by dllo on 16/5/17.
 */
public class EntertainmentFragment extends BaseFragment implements MyClickListener {
    private RecyclerView recyclerView;
    EntertainmentAdapter entertainmentAdapter;
    private EntertainmentBean bean;
    private Intent intent;

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
        entertainmentAdapter = new EntertainmentAdapter(this.context);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 3));
        recyclerView.setAdapter(entertainmentAdapter);
        recyclerView.setHasFixedSize(true);
        entertainmentAdapter.setClickListener(this);
    }

    public void initResponse() {
        RequestQueue requestQueue = Volley.newRequestQueue(this.context);
        GsonRequest<EntertainmentBean> request = new GsonRequest<>(com.android.volley.Request.Method.GET, URLTool.VIDEO_COMMENT, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<EntertainmentBean>() {
            @Override
            public void onResponse(EntertainmentBean response) {
                bean = response;
                entertainmentAdapter.setBean(bean);
            }
        }, EntertainmentBean.class);
        requestQueue.add(request);
    }


    @Override
    public void OnClick(int pos) {
        intent = new Intent(this.context, EntertainmentActivity.class);
        String id = bean.getData().get(0).getCatword_id().get(pos).getId();
        String url = bean.getData().get(0).getCatword_id().get(pos).getPic_url();
        String title = bean.getData().get(0).getCatword_id().get(pos).getName();
        String article = bean.getData().get(0).getCatword_id().get(pos).getDesc();
        intent.putExtra("imageurl" , url);
        intent.putExtra("titleTv" , title);
        intent.putExtra("article" , article);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public EntertainmentBean getData() {
        return bean;
    }
}
