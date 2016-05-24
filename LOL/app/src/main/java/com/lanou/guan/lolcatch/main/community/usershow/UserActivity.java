package com.lanou.guan.lolcatch.main.community.usershow;

import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseActivity;
import com.lanou.guan.lolcatch.main.base.URLTool;
import com.lanou.guan.lolcatch.main.base.VolleySingle;

/**
 * Created by dllo on 16/5/18.
 */
public class UserActivity extends BaseActivity {
    private ListView listView;
    private UserShowBean bean;
    private UserShowAdapter showAdapter;
    @Override
    public int initLayout() {
        return R.layout.activity_user_show;
    }

    @Override
    public void initView() {
        listView = (ListView) findViewById(R.id.user_show_lv);
    }

    @Override
    public void initData() {
        initResponse();
        showAdapter = new UserShowAdapter(this);
        listView.setAdapter(showAdapter);

    }
    private void initResponse() {
        VolleySingle.addRequest(URLTool.COMMUNITY_USER_SHOW, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<UserShowBean>() {
            @Override
            public void onResponse(UserShowBean response) {
                bean = response;
                showAdapter.setBean(bean);
            }
        },UserShowBean.class);
    }

}
