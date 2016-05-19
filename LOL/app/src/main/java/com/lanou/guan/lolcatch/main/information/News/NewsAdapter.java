package com.lanou.guan.lolcatch.main.information.News;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lanou.guan.lolcatch.R;

/**
 * Created by dllo on 16/5/17.
 */
public class NewsAdapter extends BaseAdapter {
    private Context context;
    private NewsBean newsBean;

    public NewsAdapter(Context context) {
        this.context = context;
    }

    public void setNewsBean(NewsBean newsBean) {
        this.newsBean = newsBean;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return newsBean == null ? 0 : newsBean.getData().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.titleTv.setText(newsBean.getData().get(position).getTitle());
        holder.articleTv.setText(newsBean.getData().get(position).getDesc());
        return convertView;
    }

    class ViewHolder {
        TextView titleTv;
        TextView articleTv;

        public ViewHolder(View itemView) {
            titleTv = (TextView) itemView.findViewById(R.id.news_title_tv);
            articleTv = (TextView) itemView.findViewById(R.id.news_article_tv);
        }

    }
}