package com.lanou.guan.lolcatch.main.hero.all;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseFragment;
import com.lanou.guan.lolcatch.main.base.MyClickListener;
import com.lanou.guan.lolcatch.main.base.URLTool;
import com.lanou.guan.lolcatch.main.base.VolleySingle;
import com.lanou.guan.lolcatch.main.hero.mainhero.HeroDetailActivity;

/**
 * Created by dllo on 16/5/16.
 */
public class AllHeroFragment extends BaseFragment implements MyClickListener{
    private AllHeroAdapter adapter;
    private AllHeroBean bean;
    private RecyclerView recyclerView;
    private String type = "all";
    @Override
    protected int setLayout() {
        return R.layout.fragment_free_hero;
    }

    @Override
    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.hero_rv);
    }

    @Override
    protected void initData() {
        initResponse();
        adapter = new AllHeroAdapter(this.context);
        recyclerView.setLayoutManager(new GridLayoutManager(context,4));
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
    }

    void initResponse() {
        VolleySingle.addRequest(URLTool.HERO + type, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<AllHeroBean>() {
            @Override
            public void onResponse(AllHeroBean response) {
                bean = response;
                Log.d("AllHeroFragment", "title" + bean.getAll().get(1).getTitle());
                adapter.setBean(bean);
            }
        },AllHeroBean.class);
    }

    @Override
    public void OnClick(int pos) {
        Intent intent = new Intent(this.context, HeroDetailActivity.class);
        startActivity(intent);
    }
}
