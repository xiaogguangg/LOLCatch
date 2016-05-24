package com.lanou.guan.lolcatch.main.information.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.MyClickListener;
import com.lanou.guan.lolcatch.main.information.bean.Bean;

/**
 * Created by dllo on 16/5/14.
 */
public class InformationDetailAdapter extends BaseAdapter {
    private Context context;
    private Bean bean;
    private MyClickListener clickListener;
//    private int inCrease = bean.getData().size();
//    public void setInCrease(int inCrease) {
//        this.inCrease = inCrease;
//        notifyDataSetChanged();
//    }

    public void setClickListener(MyClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public InformationDetailAdapter(Context context) {
        this.context = context;
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean == null ? 0 : bean.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return bean.getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_information, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.titleTv.setText(bean.getData().get(position).getTitle());
        viewHolder.articleTv.setText(bean.getData().get(position).getDesc());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.OnClick(position);
            }
        });
        return convertView;
    }

    class ViewHolder {
        ImageView iv;
        TextView titleTv;
        TextView articleTv;

        public ViewHolder(View itemView) {
            titleTv = (TextView) itemView.findViewById(R.id.newest_title_tv);
            articleTv = (TextView) itemView.findViewById(R.id.newest_article_tv);
            iv = (ImageView) itemView.findViewById(R.id.newest_iv);
        }
    }
}
