package com.lanou.guan.lolcatch.main.main;

import android.widget.EditText;
import android.widget.ImageButton;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseActivity;

/**
 * Created by dllo on 16/5/16.
 */
public class CheckActivity extends BaseActivity {
    private EditText editText;
    private ImageButton checkIb;

    @Override
    public int initLayout() {
        return R.layout.activity_check;
    }

    @Override
    public void initView() {
        editText = (EditText) findViewById(R.id.check_et);
        checkIb = (ImageButton) findViewById(R.id.check_ib);
    }

    @Override
    public void initData() {
        this.setTitle("搜索");

    }
}
