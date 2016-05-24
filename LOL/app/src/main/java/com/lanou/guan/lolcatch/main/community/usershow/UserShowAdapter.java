package com.lanou.guan.lolcatch.main.community.usershow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.guan.lolcatch.R;
import com.lanou.guan.lolcatch.main.base.MyClickListener;
import com.lanou.guan.lolcatch.main.base.PicassoCirclTransform;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by dllo on 16/5/18.
 */
public class UserShowAdapter extends BaseAdapter {
    private UserShowBean bean;
    private Context context;
    private MyClickListener clickListener;

    public void setClickListener(MyClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public UserShowAdapter(Context context) {
        this.context = context;
    }

    public void setBean(UserShowBean bean) {
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
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_user_show,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(bean.getData().get(position).getAvatar()).resize(150,150).transform(new PicassoCirclTransform()).into(holder.headIv);
        holder.userName.setText(bean.getData().get(position).getNickname());
        holder.userIntroduce.setText("召唤师:(" + bean.getData().get(position).getArea() + ")"+bean.getData().get(position).getSummoner());
        Picasso.with(context).load(bean.getData().get(position).getPic_url()).resize(1000,1200).into(holder.userPhoto);
        holder.userDescribe.setText(bean.getData().get(position).getDesc());
        holder.headIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.OnClick(position);
            }
        });
        return convertView;
    }
    class ViewHolder{
        private ImageView headIv;
        private TextView userName;
        private TextView userIntroduce;
        private ImageView userPhoto;
        private TextView userDescribe;
        public ViewHolder(View view) {
            headIv = (ImageView) view.findViewById(R.id.head_image);
            userName = (TextView) view.findViewById(R.id.user_name);
            userIntroduce = (TextView) view.findViewById(R.id.user_introduce);
            userPhoto = (ImageView) view.findViewById(R.id.user_photo);
            userDescribe = (TextView) view.findViewById(R.id.user_describe);
        }
    }
}
