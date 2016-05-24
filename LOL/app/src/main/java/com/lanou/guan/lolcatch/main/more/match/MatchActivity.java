package com.lanou.guan.lolcatch.main.more.match;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseActivity;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.more.match.matchdetail.ImportentNewsFragment;
import com.lanou.guan.lolcatch.main.more.match.matchdetail.MatchDataFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/23.
 */
public class MatchActivity extends BaseActivity {
    private ViewPager matchVp;
    private TabLayout matchTb;
    private MatchAdapter adapter;
    private List<BaseFragment> fragments;
    @Override
    public int initLayout() {
        return R.layout.activity_match;
    }

    @Override
    public void initView() {
        matchTb = (TabLayout) findViewById(R.id.match_tb);
        matchVp = (ViewPager) findViewById(R.id.match_vp);
    }

    @Override
    public void initData() {
        adapter = new MatchAdapter(getSupportFragmentManager());
        iniFragment();
        adapter.setFragments(fragments);
        matchVp.setAdapter(adapter);
        matchTb.setupWithViewPager(matchVp);

    }

    private void iniFragment() {
        fragments = new ArrayList<>();
        fragments.add(new MatchDataFragment());
        fragments.add(new ImportentNewsFragment());
    }

}
