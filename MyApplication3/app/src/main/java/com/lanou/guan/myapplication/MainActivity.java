package com.lanou.guan.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    List<Bean> beanList;
    MainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv);
        adapter = new MainAdapter(this);
        initBean();
        adapter.setBeans(beanList);
        listView.setAdapter(adapter);
    }
    public void initBean(){
        beanList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            beanList.add(new Bean("我要写代码"));
            beanList.add(new Bean("我要写代码"));
            beanList.add(new Bean("我要写代码"));

        }
    }
}
