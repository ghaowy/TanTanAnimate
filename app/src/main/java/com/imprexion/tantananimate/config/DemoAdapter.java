package com.imprexion.tantananimate.config;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.imprexion.tantananimate.R;

import java.util.List;

/**
 * @author : gongh
 * @date : 2020/3/20 14:00
 * @desc : TODO
 */
public class DemoAdapter extends RecyclerView.Adapter {

    private final LayoutInflater mInflater;
    private List<SwipeBean> mDatas;

    public DemoAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    public void setDatas(List<SwipeBean> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CardHolder(mInflater.inflate(R.layout.view_item_card, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        CardHolder cardHolder = (CardHolder) viewHolder;

        cardHolder.updateData(mDatas.get(i));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    static class CardHolder extends RecyclerView.ViewHolder {

        private final TextView mTvNumber;
        private final ImageView mIvCard;

        public CardHolder(@NonNull View itemView) {
            super(itemView);
            mIvCard = itemView.findViewById(R.id.iv_card);
            mTvNumber = itemView.findViewById(R.id.tv_number);
        }

        public void updateData(SwipeBean swipeBean) {
            int number = swipeBean.getNumber();
            String url = swipeBean.getUrl();
            Glide.with(itemView.getContext().getApplicationContext())
                    .load(url)
                    .into(mIvCard);
            mTvNumber.setText("DATA " + number);

        }
    }
}
