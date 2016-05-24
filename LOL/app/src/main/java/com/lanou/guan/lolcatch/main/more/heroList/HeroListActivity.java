package com.lanou.guan.lolcatch.main.more.heroList;

import android.widget.ListView;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseActivity;

/**
 * Created by dllo on 16/5/23.
 */
public class HeroListActivity extends BaseActivity {
    private ListView listView;
    @Override
    public int initLayout() {
        return R.layout.activity_herolist;
    }

    @Override
    public void initView() {
        listView = (ListView) findViewById(R.id.matcn_lv);
    }

    @Override
    public void initData() {

    }
}
