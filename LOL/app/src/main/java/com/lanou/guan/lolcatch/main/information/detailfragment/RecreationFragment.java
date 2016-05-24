package com.lanou.guan.lolcatch.main.information.detailfragment;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.base.MyClickListener;
import com.lanou.guan.lolcatch.main.base.URLTool;
import com.lanou.guan.lolcatch.main.base.VolleySingle;
import com.lanou.guan.lolcatch.main.information.adapter.InformationDetailAdapter;
import com.lanou.guan.lolcatch.main.information.adapter.ViewPagerAdapter;
import com.lanou.guan.lolcatch.main.information.bean.Bean;
import com.lanou.guan.lolcatch.main.information.maininformation.InformationDetailAty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/14.
 */
public class RecreationFragment extends BaseFragment implements MyClickListener{
    private ListView listView;
    private PullToRefreshListView pullToRefreshListView;
    private InformationDetailAdapter recreationAdapter;
    private List<ImageView> imageViews;
    private ImageView imageView;
    private ViewPager imageVp;
    private Bean bean;
    private int currentItem;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    protected int setLayout() {
        return R.layout.fragment_information_detail;
    }

    @Override
    protected void initView(View view) {
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.newest_lv);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
    }

    @Override
    protected void initData() {
        listView = pullToRefreshListView.getRefreshableView();
        initImageView();
        View view = LayoutInflater.from(context).inflate(R.layout.image_vp, null);
        imageVp = (ViewPager) view.findViewById(R.id.all_vp);
        ViewPagerAdapter vpAdapter = new ViewPagerAdapter(imageViews);
        imageVp.setAdapter(vpAdapter);
        listView.addHeaderView(view);
        imageVp.setAdapter(vpAdapter);
        //______________________________
        recreationAdapter = new InformationDetailAdapter(getContext());
        recreationAdapter.setClickListener(this);
        listView.setAdapter(recreationAdapter);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                initResponse();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                initResponse();
            }
        });

    }
    public void initResponse(){
        VolleySingle.addRequest(URLTool.INFORMATION_NEWS, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }, new Response.Listener<Bean>() {
            @Override
            public void onResponse(Bean response) {
                bean = response;
                recreationAdapter.setBean(bean);
            }
        }, Bean.class);
    }
    public void initImageView() {
        List<String> urls = new ArrayList<>();
        urls.add(URLTool.INFORMATION_IMAGE_FOURTH);
        urls.add(URLTool.INFORMATION_IMAGE_SECOND);
        urls.add(URLTool.INFORMATION_IMAGE_THIRD);
        urls.add(URLTool.INFORMATION_IMAGE_FOURTH);
        imageViews = new ArrayList<>();
        for (int i = 0; i < urls.size(); i++) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Log.d("NewestFragment", "imageView:" + imageViews);
            Picasso.with(context).load(urls.get(i)).into(imageView);
            imageViews.add(imageView);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case Menu.FIRST+0:
                break;
            case Menu.FIRST+1:
                break;
            case  Menu.FIRST+2:
                break;
            case Menu.FIRST+3:
                break;
        }
        return true;
    }

    @Override
    public void OnClick(int pos) {
        Intent intent = new Intent(this.context, InformationDetailAty.class);
        intent.putExtra("id",bean.getData().get(pos).getId());
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPageTask(),5,5, TimeUnit.SECONDS);
    }
    private class ViewPageTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageViews.size();
            mHandler.sendEmptyMessage(0);
        }
    }
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            imageVp.setCurrentItem(currentItem);
        }
    };

    @Override
    public void onStop() {
        super.onStop();
    }
}
