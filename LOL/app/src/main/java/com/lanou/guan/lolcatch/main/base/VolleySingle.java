package com.lanou.guan.lolcatch.main.base;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Objects;

/**
 * Created by dllo on 16/5/16.
 */
public class VolleySingle {
    private static Context mContext;
    private RequestQueue queue;//请求队列
    private static VolleySingle ourInstance = new VolleySingle(mContext);
    //获取单例的对象
    public static VolleySingle getInstance() {
        return ourInstance;
    }

    private VolleySingle(Context context) {
        //获取APP中的context
        mContext = context.getApplicationContext();
        queue = getQueue();
    }
    private RequestQueue getQueue(){
        if (queue == null){
            queue = Volley.newRequestQueue(mContext);
        }
        return queue;
    }
    public static final String TAG = "VolleySingLeton";
    //添加请求
    public  <T> void addRequest(Request<T> request){
        request.setTag(TAG);//为我的请求添加标签
        queue.add(request);//将请求添加到队列当中
    }
    public <T> void addRequest(Request<T> request , Objects tag){
        request.setTag(tag);
        queue.add(request);
    }
    public void _addRequest(String url , Response.Listener listener, Response.ErrorListener errorListener){
        StringRequest stringRequest = new StringRequest(url,listener,errorListener);
        _addRequest(stringRequest);
    }

    private void _addRequest(StringRequest stringRequest) {
    }

    private <T>void _addRequest(String url , Class<T> mClass, Response.Listener listener , Response.ErrorListener errorListener) {
        /*GsonRequest gsonRequest = new GsonRequest{
        }
        _addRequest(gsonRequest);*/

    }
    //这个方法将请求队列移除
    public void removeRequest(Object tag){
        queue.cancelAll(tag);
    }
    public static void addRequest(String url , Response.Listener<String> listener , Response.ErrorListener errorListener){
        //获取单例对象,调用添加请求的方法(这是StringRequest的请求)
        getInstance()._addRequest(url, listener, errorListener);
    }
    public static <T> void addRequest(String url,Class<T> mClass , Response.Listener<T> listener , Response.ErrorListener errorListener){
        getInstance()._addRequest(url , mClass,listener,errorListener);
    }
}
