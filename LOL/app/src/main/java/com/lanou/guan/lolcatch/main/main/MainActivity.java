package com.lanou.guan.lolcatch.main.main;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseActivity;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.community.maincommunity.CommunityFragment;
import com.lanou.guan.lolcatch.main.hero.mainhero.HeroFragment;
import com.lanou.guan.lolcatch.main.information.maininformation.InformationFragment;
import com.lanou.guan.lolcatch.main.more.fragment.MoreFragment;
import com.lanou.guan.lolcatch.main.video.mainvideo.video.VideoFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private ViewPager mainVP;
    private MainAdapter mainAdapter;
    private RadioGroup radioGroup;
    private List<BaseFragment> fragments;
    private TextView titleTv;
    private ImageButton centerIB;
    private ImageButton checkIB;
    private ImageButton downLoadIB;
    private Intent intent;
    private DrawerLayout drawerLayout;
    private RelativeLayout logInLayout;
    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mainVP = (ViewPager) findViewById(R.id.main_vp);
        radioGroup = (RadioGroup) findViewById(R.id.main_rg);
        titleTv = (TextView) findViewById(R.id.title_tv);
        centerIB = (ImageButton) findViewById(R.id.title_center_ib);
        checkIB = (ImageButton) findViewById(R.id.title_check_ib);
        downLoadIB = (ImageButton) findViewById(R.id.title_download_ib);
        radioGroup = (RadioGroup) findViewById(R.id.main_rg);
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer);
        logInLayout = (RelativeLayout) findViewById(R.id.log_in_layout);

    }

    @Override
    public void initData() {
        initFragment();
        mainAdapter = new MainAdapter(getSupportFragmentManager());
        mainAdapter.setFragments(fragments);
        mainVP.setAdapter(mainAdapter);
        centerIB.setOnClickListener(this);
        checkIB.setOnClickListener(this);
        downLoadIB.setOnClickListener(this);
        logInLayout.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new CheckedChangeListener());
        mainVP.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

            @Override
            public void onPageSelected(int position) {
                setTitleBar(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new InformationFragment());
        fragments.add(new VideoFragment());
        fragments.add(new HeroFragment());
        fragments.add(new CommunityFragment());
        fragments.add(new MoreFragment());
    }
    private class CheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.information_rb:
                    mainVP.setCurrentItem(0);
                    break;
                case R.id.video_rb:
                    mainVP.setCurrentItem(1);
                    break;
                case R.id.hero_rb:
                    mainVP.setCurrentItem(2);
                    break;
                case R.id.community_rb:
                    mainVP.setCurrentItem(3);
                    break;
                case R.id.more_rb:
                    mainVP.setCurrentItem(4);
                    break;
            }
        }
    }
    private void setTitleBar(int pos){
        titleTv.setText(mainAdapter.getPageTitle(pos));
        switch (pos){
            case 0:
                centerIB.setVisibility(View.VISIBLE);
                checkIB.setVisibility(View.VISIBLE);
                downLoadIB.setVisibility(View.GONE);
                radioGroup.check(R.id.information_rb);
                break;
            case 1:
                centerIB.setVisibility(View.VISIBLE);
                checkIB.setVisibility(View.GONE);
                downLoadIB.setVisibility(View.VISIBLE);
                radioGroup.check(R.id.video_rb);
                break;
            case 2:
                centerIB.setVisibility(View.VISIBLE);
                checkIB.setVisibility(View.GONE);
                downLoadIB.setVisibility(View.GONE);
                radioGroup.check(R.id.hero_rb);
                break;
            case 3:
                centerIB.setVisibility(View.VISIBLE);
                checkIB.setVisibility(View.GONE);
                downLoadIB.setVisibility(View.GONE);
                radioGroup.check(R.id.community_rb);
                break;
            case 4:
                centerIB.setVisibility(View.VISIBLE);
                checkIB.setVisibility(View.GONE);
                downLoadIB.setVisibility(View.GONE);
                radioGroup.check(R.id.more_rb);
                break;
        }
    }


    @Override
    public void onClick(View v) {
        intent = new Intent();
        switch (v.getId()){
            case R.id.title_check_ib:
                intent.setClass(this,CheckActivity.class);
                startActivity(intent);
                break;
            case R.id.title_download_ib:
                intent.setClass(this,DownLoadActivity.class);
                startActivity(intent);
                break;
            case R.id.title_center_ib:
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.log_in_layout:
                intent.setClass(this,LogInActivity.class);
                startActivity(intent);

        }
    }
}
