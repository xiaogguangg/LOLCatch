package com.lanou.guan.lolcatch.main.video.mainvideo.entertainment;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.guan.lolcatch.R;

/**
 * Created by dllo on 16/5/18.
 */
public class EntertainmentAdapter extends RecyclerView.Adapter <EntertainmentAdapter.ViewHolder>{
    private Context context;
    private EntertainmentBean bean;
    public EntertainmentAdapter(Context context) {
        this.context = context;
    }

    public void setBean(EntertainmentBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_comment,parent,false);
        ViewHolder holder = new ViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageURI(Uri.parse(bean.getData().get(position).getCatword_id().get(position).getPic_url()));
        holder.textView.setText(bean.getData().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) imageView.findViewById(R.id.comment_iv);
            textView = (TextView) itemView.findViewById(R.id.comment_tv);
        }
    }
}
