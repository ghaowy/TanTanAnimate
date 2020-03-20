package com;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.imprexion.tantananimate.config.DemoDragAdapter;
import com.imprexion.tantananimate.config.SwipeBean;

import java.util.Collections;
import java.util.List;

/**
 * @author : gongh
 * @date : 2020/3/20 15:25
 * @desc : TODO
 */
public class MyDraghHelperCallback extends ItemTouchHelper.Callback {

    private DemoDragAdapter mDragAdapter;
    private List<SwipeBean> mSwipeBeans;

    public MyDraghHelperCallback(DemoDragAdapter dragAdapter, List<SwipeBean> swipeBeans) {
        mDragAdapter = dragAdapter;
        mSwipeBeans = swipeBeans;
    }


    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        //允许上下拖拽
        int drag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //允许向左滑动
        int swipe = ItemTouchHelper.LEFT;
        //设置
        return makeMovementFlags(drag,swipe);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        //交换集合中两个数据的位置
        Collections.swap(mSwipeBeans,viewHolder.getAdapterPosition(),viewHolder1.getAdapterPosition());
        //刷新界面,局部刷新,索引会混乱
        mDragAdapter.notifyItemMoved(viewHolder.getAdapterPosition(),viewHolder1.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        mSwipeBeans.remove(viewHolder.getAdapterPosition());
        mDragAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
    }
}
