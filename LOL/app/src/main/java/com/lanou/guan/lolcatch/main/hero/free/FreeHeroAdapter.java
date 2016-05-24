package com.lanou.guan.lolcatch.main.hero.free;

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
public class FreeHeroAdapter extends RecyclerView.Adapter<FreeHeroAdapter.MyViewHolder> {
    private FreeHeroBean bean;
    private Context context;
    private MyClickListener clickListener;

    public void setClickListener(MyClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setBean(FreeHeroBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    public FreeHeroAdapter(Context context) {
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_hero,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Picasso.with(context).load(URLTool.HERO_IMAGE_START + bean.getFree().get(position).getEnName() + URLTool.HERO_IMAGE_CENTER + bean.getFree().get(position).getEnName() + URLTool.HERO_IMAGE_END).into(holder.headIv);
        holder.heroNameTv.setText(bean.getFree().get(position).getTitle());
        holder.heroPriceTv.setText(bean.getFree().get(position).getPrice());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.OnClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bean == null ? 0 : bean.getFree().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView headIv;
        TextView heroNameTv;
        TextView heroPriceTv;
        public MyViewHolder(View itemView) {
            super(itemView);
            headIv = (ImageView) itemView.findViewById(R.id.head_iv);
            heroNameTv = (TextView) itemView.findViewById(R.id.hero_name_tv);
            heroPriceTv = (TextView) itemView.findViewById(R.id.hero_price_tv);

        }
    }
}
