package com.lanou.guan.lolcatch.main.information.maininformation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lanou.guan.lolcatch.main.base.URLTool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/18.
 */
public abstract class InformationUseFragment extends Fragment {
    protected Context context;
    protected int oldPosition;
    protected int currentItem;
    protected ScheduledExecutorService scheduledExecutorService;
    protected List<ImageView> imageViews;
    private ViewPager imageVp;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(setLayout(),container,false);
    }

    protected abstract int setLayout();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    protected abstract void initView(View view);

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();
    public void initImageView() {
        imageViews = new ArrayList<>();
        List<String> urls = new ArrayList<>();
        urls.add(URLTool.INFORMATION_IMAGE_FIRST);
        urls.add(URLTool.INFORMATION_IMAGE_SECOND);
        urls.add(URLTool.INFORMATION_IMAGE_THIRD);
        ImageView imageView = new ImageView(this.getActivity());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        for (int i = 0; i < urls.size(); i++) {
            Picasso.with(context).load(urls.get(i)).into(imageView);
            imageViews.add(imageView);
        }
        inImageView();
    }

    protected abstract void inImageView();

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.FIRST,Menu.FIRST+0,0,"setting");
        menu.add(Menu.FIRST, Menu.FIRST+1, 1, "reBack");
        menu.add(Menu.FIRST, Menu.FIRST + 2, 2, "lanou3g");
        inCreateOptionsMenu(menu);
        return true;

    }

    protected abstract void inCreateOptionsMenu(Menu menu);

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
    public abstract boolean inOptionsItemSelected(MenuItem item);
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
        scheduledExecutorService.scheduleWithFixedDelay(new ViewPageTask(),3,3, TimeUnit.SECONDS);
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
