package com.lanou.guan.lolcatch.main.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanou.guan.lolcatch.main.base.BaseFragment;

import java.util.List;

/**
 * Created by dllo on 16/5/14.
 */
public class MainAdapter extends FragmentPagerAdapter{
    private List<BaseFragment> fragments;
    private String[] titles = {"新闻资讯" , "游戏视频" ,"英雄列表","社区","更多"};

    public void setFragments(List<BaseFragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
