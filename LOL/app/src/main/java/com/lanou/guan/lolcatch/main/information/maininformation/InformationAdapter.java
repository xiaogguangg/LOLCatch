package com.lanou.guan.lolcatch.main.information.maininformation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanou.guan.lolcatch.main.base.BaseFragment;

import java.util.List;

/**
 * Created by dllo on 16/5/14.
 */
public class InformationAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> baseFragments;
    private String[] title = { "最新" , "新闻" , "赛事" , "娱乐"};
    public void setBaseFragments(List<BaseFragment> baseFragments) {
        this.baseFragments = baseFragments;
    }

    public InformationAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return baseFragments.get(position);
    }

    @Override
    public int getCount() {
        return baseFragments == null ? 0 : baseFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
