package com.lanou.guan.lolcatch.main.information.newest;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/14.
 */
public class NewestFragment extends BaseFragment {
    private ListView listView;
    private NewestAdapter newestAdapter;
    private List<ImageView> imageViews;
    private ImageView imageView;
    private ViewPager imageVp;
    private Bean bean;
    private ChangeImageBean imageBean;
    private int oldPosition = 0;
    private int currentItem;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    protected int setLayout() {
        return R.layout.fragment_newest;
    }

    @Override
    protected void initView(View view) {
        listView = (ListView) view.findViewById(R.id.newest_lv);
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
        initResponse();
        newestAdapter = new NewestAdapter(getContext());
        listView.setAdapter(newestAdapter);
    }

    private void initResponse() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        GsonRequest<Bean> gsonRequest = new GsonRequest<>(com.android.volley.Request.Method.GET, URLTool.INFORMATION_NEWEST, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }, new Response.Listener<Bean>() {
            @Override
            public void onResponse(Bean response) {
                bean = response;
                newestAdapter.setBean(bean);
            }
        }, Bean.class);
        requestQueue.add(gsonRequest);
    }

    public void initImageView() {
        RequestQueue imageQueue = Volley.newRequestQueue(getContext());
        GsonRequest<ChangeImageBean> imageGsonRequest = new GsonRequest<>(com.android.volley.Request.Method.GET, " http://lol.zhangyoubao.com/apis/rest/ItemsService/ads?&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438744725&p_=16520&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol", new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }, new Response.Listener<ChangeImageBean>() {
            @Override
            public void onResponse(ChangeImageBean response) {
                imageBean = response;
                imageViews = new ArrayList<>();
                for (int i = 0; i < imageBean.getData().size(); i++) {
                    imageView = new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Picasso.with(context).load(imageBean.getData().get(i).getPic_ad_url()).into(imageView);
                    imageViews.add(imageView);

                }
            }
        }, ChangeImageBean.class);
        imageQueue.add(imageGsonRequest);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.FIRST,Menu.FIRST+0,0,"setting");
        menu.add(Menu.FIRST, Menu.FIRST+1, 1, "reBack");
        menu.add(Menu.FIRST,Menu.FIRST+2,2,"lanou3g");
        return true;
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
        }
        return true;
    }

    class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            currentItem = oldPosition;
        }
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

