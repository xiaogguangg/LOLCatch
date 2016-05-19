package com.lanou.guan.lolcatch.main.information.newest;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.VideoView;

import com.lanou.guan.lolcatch.R;

/**
 * Created by dllo on 16/5/14.
 */
public class NewestAdapter extends BaseAdapter {
    private Context context;
    private Bean bean;
    public NewestAdapter(Context context) {
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_newest,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.titleTv.setText(bean.getData().get(position).getTitle());
        viewHolder.articleTv.setText(bean.getData().get(position).getDesc());
        if (bean.getData().get(position).getPic_url() != null) {
            viewHolder.videoView.setVideoURI(Uri.parse(bean.getData().get(position).getVideo_url()));
        }
        return convertView;
    }
    class ViewHolder{
        VideoView videoView;
        TextView titleTv;
        TextView articleTv;
        public ViewHolder(View itemView) {
            titleTv = (TextView) itemView.findViewById(R.id.newest_title_tv);
            articleTv = (TextView) itemView.findViewById(R.id.newest_article_tv);
            videoView = (VideoView) itemView.findViewById(R.id.newest_vv);
        }
    }
}
