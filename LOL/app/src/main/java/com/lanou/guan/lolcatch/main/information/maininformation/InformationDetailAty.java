package com.lanou.guan.lolcatch.main.information.maininformation;

import android.content.Intent;
import android.webkit.WebView;
import android.widget.PopupWindow;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.BaseActivity;

/**
 * Created by dllo on 16/5/20.
 */
public class InformationDetailAty extends BaseActivity {
    private WebView webView;
    private String url;
    private Intent intent;
    private String id;
    private PopupWindow menuPopup;
    @Override
    public int initLayout() {
        return R.layout.aty_detail_information;
    }

    @Override
    public void initView() {
        webView = (WebView) findViewById(R.id.information_web);
        intent = getIntent();
        id = intent.getStringExtra("id");
    }

    @Override
    public void initData() {
        url = " http://lol.zhangyoubao.com/mobiles/item/"+id+"?user_id=&token=&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438754752&p_=16601&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol&size=middle";
        webView.loadUrl(url);
    }
}
