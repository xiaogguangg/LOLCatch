package com.lanou.guan.lolcatch.main.hero.free;

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
public class FreeHeroFragment extends BaseFragment implements MyClickListener{
    private String type =  "free";
    private RecyclerView heroRv;
    private FreeHeroAdapter heroAdapter;
    private FreeHeroBean bean;
    @Override
    protected int setLayout() {
        return R.layout.fragment_free_hero;
    }

    @Override
    protected void initView(View view) {
        heroRv = (RecyclerView) view.findViewById(R.id.hero_rv);
    }
    @Override
    protected void initData() {
        initRequest();
        heroAdapter = new FreeHeroAdapter(this.context);
        heroRv.setLayoutManager(new GridLayoutManager(context,4));
        heroRv.setAdapter(heroAdapter);
        heroAdapter.setClickListener(this);
    }


    void initRequest() {
        VolleySingle.addRequest(URLTool.HERO + type, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<FreeHeroBean>() {
            @Override
            public void onResponse(FreeHeroBean response) {
                bean = response;
                Log.d("AllHeroFragment", "title" + bean.getFree().get(1).getTitle());
                heroAdapter.setBean(bean);
            }
        },FreeHeroBean.class);
    }

    @Override
    public void OnClick(int pos) {
        Intent intent = new Intent(this.context, HeroDetailActivity.class);
        startActivity(intent);
    }
}
