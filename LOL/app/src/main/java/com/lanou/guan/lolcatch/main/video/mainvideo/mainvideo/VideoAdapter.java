package com.lanou.guan.lolcatch.main.video.mainvideo.mainvideo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lanou.guan.lolcatch.main.base.BaseFragment;

import java.util.List;

/**
 * Created by dllo on 16/5/17.
 */
public class VideoAdapter extends FragmentPagerAdapter {
    private List<BaseFragment> baseFragments;
    private String [] title = {"娱乐","解说","赛事"};
    public void setBaseFragments(List<BaseFragment> baseFragments) {
        this.baseFragments = baseFragments;
    }

    public VideoAdapter(FragmentManager fm) {
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
