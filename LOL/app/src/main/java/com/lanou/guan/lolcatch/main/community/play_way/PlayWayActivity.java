package com.lanou.guan.lolcatch.main.community.play_way;

import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseActivity;
import com.lanou.guan.lolcatch.main.base.URLTool;
import com.lanou.guan.lolcatch.main.base.VolleySingle;

/**
 * Created by dllo on 16/5/21.
 */
public class PlayWayActivity extends BaseActivity {
    private PullToRefreshListView pullToRefreshListView;
    private ListView listView;
    private PlayWayAdapter adapter;
    private PlayWayBean bean;
    private int page = 1;
    @Override
    public int initLayout() {
        return R.layout.activity_way_play;
    }

    @Override
    public void initView() {
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.play_way_lv);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
    }

    @Override
    public void initData() {
        initResponse();
        adapter = new PlayWayAdapter(this);
        listView = pullToRefreshListView.getRefreshableView();
        listView.setAdapter(adapter);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                pullToRefreshListView.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                page++;
                initResponse();
                pullToRefreshListView.onRefreshComplete();
            }
        });
    }

    private void initResponse() {
        VolleySingle.addRequest(URLTool.COMMUNITY_PLAY_WAY_START+page+URLTool.COMMUNITY_PLAY_WAY_END, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<PlayWayBean>() {
            @Override
            public void onResponse(PlayWayBean response) {
                bean = response;
                adapter.setBean(bean);
            }
        },PlayWayBean.class);
    }

}
