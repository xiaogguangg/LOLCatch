package com.lanou.guan.lolcatch.main.information.News;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.base.GsonRequest;
import com.lanou.guan.lolcatch.main.base.URLTool;
import com.lanou.guan.lolcatch.main.information.maininformation.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/14.
 */
public class NewsFragment extends BaseFragment {
    private ListView listView;
    private NewsAdapter newsAdapter;
    private List<ImageView> imageViews;
    private ViewPager imageVp;
    private NewsBean bean;
    private int oldPosition = 0;
    private int currentItem;
    private ScheduledExecutorService scheduledExecutorService;
    @Override
    protected int setLayout() {
        return R.layout.fragment_news;
    }

    @Override
    protected void initView(View view) {
        listView = (ListView) view.findViewById(R.id.news_lv);
    }

    @Override
    protected void initData() {
        initImageView();
        View view = LayoutInflater.from(this.context).inflate(R.layout.image_vp, null);
        imageVp = (ViewPager) view.findViewById(R.id.all_vp);
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(imageViews);
        imageVp.setAdapter(vpAdapter);
        listView.addHeaderView(view);
        imageVp.setAdapter(vpAdapter);
        //______________________________
        initRequest();
        newsAdapter = new NewsAdapter(getContext());
        listView.setAdapter(newsAdapter);
    }
    public void initRequest(){
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        GsonRequest<NewsBean> gsonRequest = new GsonRequest<>(com.android.volley.Request.Method.GET, URLTool.INFORMATION_NEWS, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }, new Response.Listener<NewsBean>() {
            @Override
            public void onResponse(NewsBean response) {
                bean = response;
                newsAdapter.setNewsBean(bean);
            }
        }, NewsBean.class);
        requestQueue.add(gsonRequest);
    }
    public void initImageView() {
        imageViews = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        urls.add(URLTool.INFORMATION_IMAGE_FIRST);
        urls.add(URLTool.INFORMATION_IMAGE_SECOND);
        urls.add(URLTool.INFORMATION_IMAGE_THIRD);
        urls.add(URLTool.INFORMATION_IMAGE_FOURTH);
        for (int i = 0; i < urls.size(); i++) {
            ImageView imageView = new ImageView(this.getActivity());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Picasso.with(context).load(urls.get(i)).into(imageView);
            imageViews.add(imageView);
        }
    }
}
