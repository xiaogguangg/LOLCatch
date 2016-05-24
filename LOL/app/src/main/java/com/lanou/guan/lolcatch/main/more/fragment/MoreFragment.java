package com.lanou.guan.lolcatch.main.more.fragment;

import android.content.Intent;
import android.view.View;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.more.match.MatchActivity;

/**
 * Created by dllo on 16/5/14.
 */
public class MoreFragment extends BaseFragment implements View.OnClickListener{
    private Intent intent;
    @Override
    protected int setLayout() {
        return R.layout.fragment_more;
    }

    @Override
    protected void initView(View view) {
        view.findViewById(R.id.check_layout).setOnClickListener(this);
        view.findViewById(R.id.match_layout).setOnClickListener(this);
        view.findViewById(R.id.hero_layout).setOnClickListener(this);
        view.findViewById(R.id.glod_layout).setOnClickListener(this);
        view.findViewById(R.id.splendred_layout).setOnClickListener(this);
        view.findViewById(R.id.talent_layout).setOnClickListener(this);
        view.findViewById(R.id.rune_layout).setOnClickListener(this);
        view.findViewById(R.id.summoner_layout).setOnClickListener(this);
        view.findViewById(R.id.equip_layout).setOnClickListener(this);
        view.findViewById(R.id.bells_layout).setOnClickListener(this);
        view.findViewById(R.id.wallpaper_layout).setOnClickListener(this);
        view.findViewById(R.id.wallpaper_layout).setOnClickListener(this);
        view.findViewById(R.id.novel_layout).setOnClickListener(this);
        view.findViewById(R.id.store_layout).setOnClickListener(this);
        view.findViewById(R.id.entertainment_layout).setOnClickListener(this);
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View v) {
        intent = new Intent();
        switch (v.getId()){
            case R.id.check_layout:
                break;
            case R.id.match_layout:
                intent.setClass(this.context, MatchActivity.class);
                startActivity(intent);
                break;
            case R.id.hero_layout:
                break;
        }
    }
}
