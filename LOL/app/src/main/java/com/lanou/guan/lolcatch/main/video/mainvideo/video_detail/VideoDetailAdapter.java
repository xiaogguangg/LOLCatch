package com.lanou.guan.lolcatch.main.video.mainvideo.video_detail;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.MyClickListener;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/18.
 */
public class VideoDetailAdapter extends RecyclerView.Adapter<VideoDetailAdapter.MyViewHolder>{
    private Context context;
    private VideoBean bean;
    private MyClickListener clickListener;
    private int pos;

    public void setPos(int pos) {
        this.pos = pos;
    }

    public VideoDetailAdapter(Context context) {
        this.context = context;
    }

    public void setClickListener(MyClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setBean(VideoBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_video_all,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.textView.setText(bean.getData().get(pos).getCatword_id().get(position).getName());
        Picasso.with(context).load(bean.getData().get(pos).getCatword_id().get(position).getPic_url()).into(holder.imageView);
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
        return bean == null ? 0 : bean.getData().get(pos).getCatword_id().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.all_video_iv);
            textView = (TextView) itemView.findViewById(R.id.all_video_tv);
        }
    }
}
