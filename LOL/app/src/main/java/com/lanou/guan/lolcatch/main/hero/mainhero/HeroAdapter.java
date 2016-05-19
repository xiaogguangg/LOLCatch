package com.lanou.guan.lolcatch.main.hero.mainhero;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanou.guan.lolcatch.main.base.BaseFragment;

import java.util.List;

/**
 * Created by dllo on 16/5/17.
 */
public class HeroAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> fragments;
    private String []title = {"周免/折扣","我的英雄","全部英雄"};

    public void setFragments(List<BaseFragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public HeroAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null? 0 : fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
