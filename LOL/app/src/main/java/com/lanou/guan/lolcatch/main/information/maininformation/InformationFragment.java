package com.lanou.guan.lolcatch.main.information.maininformation;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.information.adapter.InformationAdapter;
import com.lanou.guan.lolcatch.main.information.detailfragment.NewsFragment;
import com.lanou.guan.lolcatch.main.information.detailfragment.MatchFragment;
import com.lanou.guan.lolcatch.main.information.detailfragment.NewestFragment;
import com.lanou.guan.lolcatch.main.information.detailfragment.RecreationFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/5/14.
 */
public class InformationFragment extends BaseFragment {
    private List<BaseFragment> baseFragments;
    private ViewPager informationVp;
    private TabLayout informationTb;
    private InformationAdapter informationAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_information;
    }

    @Override
    protected void initView(View view) {
        informationVp = (ViewPager) view.findViewById(R.id.information_vp);
        informationTb = (TabLayout) view.findViewById(R.id.information_tb);
    }

    @Override
    protected void initData() {
        initFragment();

        informationAdapter = new InformationAdapter(getFragmentManager());
        informationAdapter.setBaseFragments(baseFragments);
        informationVp.setAdapter(informationAdapter);
        informationTb.setupWithViewPager(informationVp);
        informationVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void initFragment(){
        baseFragments = new ArrayList<>();
        baseFragments.add(new NewestFragment());
        baseFragments.add(new NewsFragment());
        baseFragments.add(new MatchFragment());
        baseFragments.add(new RecreationFragment());

    }
}
