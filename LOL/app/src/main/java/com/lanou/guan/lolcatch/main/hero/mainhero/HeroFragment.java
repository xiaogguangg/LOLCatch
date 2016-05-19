package com.lanou.guan.lolcatch.main.hero.mainhero;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.hero.all.AllHeroFragment;
import com.lanou.guan.lolcatch.main.hero.free.FreeHeroFragment;
import com.lanou.guan.lolcatch.main.hero.my.MyHeroFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/14.
 */
public class HeroFragment  extends BaseFragment {
    private List<BaseFragment> fragments;
    private HeroAdapter adapter;
    private ViewPager heroVP;
    private TabLayout heroTB;
    @Override
    protected int setLayout() {
        return R.layout.fragment_hero;
    }

    @Override
    protected void initView(View view) {
        heroTB = (TabLayout) view.findViewById(R.id.hero_tb);
        heroVP = (ViewPager) view.findViewById(R.id.hero_vp);
    }

    @Override
    protected void initData() {
        initFragment();
        adapter = new HeroAdapter(getFragmentManager());
        adapter.setFragments(fragments);
        heroVP.setAdapter(adapter);
        heroTB.setupWithViewPager(heroVP);
    }
    public void initFragment(){
        fragments = new ArrayList<>();
        fragments.add(new AllHeroFragment());
        fragments.add(new FreeHeroFragment());
        fragments.add(new MyHeroFragment());
    }
}
