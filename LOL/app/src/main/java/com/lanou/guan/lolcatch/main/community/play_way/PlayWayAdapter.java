package com.lanou.guan.lolcatch.main.community.play_way;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.guan.lolcatch.R;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/21.
 */
public class PlayWayAdapter extends BaseAdapter {
    private Context context;
    private PlayWayBean bean;

    public PlayWayAdapter(Context context) {
        this.context = context;
    }

    public void setBean(PlayWayBean bean) {
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean == null ? 0 :bean.getData().size();
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
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_play_way, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(bean.getData().get(position).getAvatar()).into(holder.headIv);
        Picasso.with(context).load(bean.getData().get(position).getFile_url()).into(holder.equipmentIv);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }

    class ViewHolder{
        ImageView headIv;
        TextView titleTv;
        ImageView equipmentIv;
        public ViewHolder(View view) {
            headIv = (ImageView) view.findViewById(R.id.head_iv);
            titleTv = (TextView) view.findViewById(R.id.title_tv);
            equipmentIv = (ImageView) view.findViewById(R.id.equipment_iv);

        }
    }
}
