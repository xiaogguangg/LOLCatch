package com.lanou.guan.lolcatch.main.hero.all;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.MyClickListener;
import com.lanou.guan.lolcatch.main.base.URLTool;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/24.
 */
public class AllHeroAdapter extends RecyclerView.Adapter<AllHeroAdapter.MyViewHolder> {
    private AllHeroBean bean;
    private Context context;
    private MyClickListener clickListener;

    public void setClickListener(MyClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public AllHeroAdapter(Context context) {
        this.context = context;
    }

    public void setBean(AllHeroBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hero,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Picasso.with(context).load(URLTool.HERO_IMAGE_START+bean.getAll().get(position).getEnName()+URLTool.HERO_IMAGE_CENTER+bean.getAll().get(position).getEnName()+URLTool.HERO_IMAGE_END).into(holder.headIv);
        holder.heroNameTv.setText(bean.getAll().get(position).getTitle());
        holder.priceTv.setText(bean.getAll().get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return bean == null ? 0 : bean.getAll().size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView headIv;
        TextView heroNameTv;
        TextView priceTv;
        public MyViewHolder(View itemView) {
            super(itemView);
            headIv = (ImageView) itemView.findViewById(R.id.head_iv);
            heroNameTv = (TextView) itemView.findViewById(R.id.hero_name_tv);
            priceTv = (TextView) itemView.findViewById(R.id.hero_price_tv);
        }
    }
}
