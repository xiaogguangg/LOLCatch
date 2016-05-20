package com.lanou.guan.lolcatch.main.video.mainvideo.entertainment.details;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.video.mainvideo.entertainment.EntertainmentFragment;
import com.lanou.guan.lolcatch.main.video.mainvideo.entertainment.MyClickListener;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/19.
 */
public class EntertainmentAtvAdapter extends RecyclerView.Adapter<EntertainmentAtvAdapter.MyViewHolder> {
    private Context context;
    private EntertainmentAtyBean bean;
    private EntertainmentFragment fragment = new EntertainmentFragment();
    private MyClickListener clickListener;

    public void setClickListener(MyClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public EntertainmentAtvAdapter(Context context) {
        this.context = context;
    }

    public void setBean(EntertainmentAtyBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_entertainment_aty,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Picasso.with(context).load(bean.getData().get(position).getPic_url()).into(holder.imageView);
        holder.titleTv.setText(bean.getData().get(position).getTitle());
        holder.articleTv.setText(bean.getData().get(position).getDesc());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();
                clickListener.OnClick(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean == null ? 0 : bean.getData().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView titleTv;
        TextView articleTv;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.entertainment_title_iv);
            titleTv = (TextView) itemView.findViewById(R.id.entertainment_title_tv);
            articleTv = (TextView) itemView.findViewById(R.id.entertainment_article_tv);
        }
    }
}
