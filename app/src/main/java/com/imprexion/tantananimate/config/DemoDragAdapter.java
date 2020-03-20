package com.imprexion.tantananimate.config;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.imprexion.tantananimate.R;

import java.util.List;

/**
 * @author : gongh
 * @date : 2020/3/20 17:34
 * @desc : TODO
 */
public class DemoDragAdapter extends RecyclerView.Adapter {
    private final LayoutInflater mInflater;
    private List<SwipeBean> mDatas;

    public DemoDragAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }


    public void setDatas(List<SwipeBean> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ListHolder(mInflater.inflate(R.layout.view_item_list, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ListHolder cardHolder = (ListHolder) viewHolder;

        cardHolder.updateData(mDatas.get(i));
    }

    @Override
    public int getItemCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    static class ListHolder extends RecyclerView.ViewHolder {

        private final TextView mTvNumber;

        public ListHolder(@NonNull View itemView) {
            super(itemView);
            mTvNumber = itemView.findViewById(R.id.tv_number);
        }

        public void updateData(SwipeBean swipeBean) {
            int number = swipeBean.getNumber();
            mTvNumber.setText("DATA " + number);

        }
    }
}
