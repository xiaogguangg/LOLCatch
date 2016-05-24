package com.lanou.guan.lolcatch.main.community.maincommunity;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.community.play_way.PlayWayActivity;
import com.lanou.guan.lolcatch.main.community.usershow.UserActivity;

/**
 * Created by dllo on 16/5/14.
 */
public class CommunityFragment extends BaseFragment implements View.OnClickListener{
    private RelativeLayout userShowlayout;
    private RelativeLayout equipmentLayout;
    private RelativeLayout findFriendLayout;
    private Intent intent;
    @Override
    protected int setLayout() {
        return R.layout.fragment_community;
    }

    @Override
    protected void initView(View view) {
        userShowlayout = (RelativeLayout) view.findViewById(R.id.usershow_click_layout);
        equipmentLayout = (RelativeLayout) view.findViewById(R.id.equipment_click_layout);
        findFriendLayout = (RelativeLayout) view.findViewById(R.id.find_friend_click_layout);
    }

    @Override
    protected void initData() {
        userShowlayout.setOnClickListener(this);
        equipmentLayout.setOnClickListener(this);
        findFriendLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        intent = new Intent();
        switch (v.getId()){
            case R.id.usershow_click_layout:
                intent.setClass(this.getActivity(), UserActivity.class);
                startActivity(intent);
                break;
            case R.id.equipment_click_layout:
                intent.setClass(this.getActivity(), PlayWayActivity.class);
                startActivity(intent);
                break;
            case R.id.find_friend_click_layout:
                break;
        }
    }
}
