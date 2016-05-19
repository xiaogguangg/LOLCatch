package com.lanou.guan.lolcatch.main.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dllo on 16/5/14.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initView();
        initData();
    }
    public abstract int initLayout();
    public abstract void initView();
    public abstract void initData();


}
