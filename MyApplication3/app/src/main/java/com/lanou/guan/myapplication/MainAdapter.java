package com.lanou.guan.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dllo on 16/5/18.
 */
public class MainAdapter extends BaseAdapter {
    private Context context;
    private List<Bean> beans;
    public MainAdapter(Context context) {
        this.context = context;
    }

    public void setBeans(List<Bean> beans) {
        this.beans = beans;
    }

    @Override
    public int getCount() {
        return beans == null ? 0 : beans.size();
    }

    @Override
    public Object getItem(int position) {
        return beans.get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(beans.get(position).getString());
        return convertView;
    }
    class ViewHolder{
        TextView textView ;
        public ViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.tv);
        }
    }
}
