package com;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;

import com.imprexion.tantananimate.config.DemoAdapter;
import com.imprexion.tantananimate.config.SwipeBean;

import java.util.List;

/**
 * @author : gongh
 * @date : 2020/3/20 15:25
 * @desc : TODO
 */
public class MyTouchHelperCallback extends ItemTouchHelper.SimpleCallback {

    private static final int DEFAULT_SPACE = 40;
    private DemoAdapter adapter;
    private List<SwipeBean> mDatas;
    private float mV;
    private int mItemCount;
    private int mStartSize;
    private int mTranslateY;


    public MyTouchHelperCallback(DemoAdapter adapter, List<SwipeBean> beans) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.adapter = adapter;
        this.mDatas = beans;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return false;
    }

    //item 滑出去后回调
    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        SwipeBean remove = mDatas.remove(viewHolder.getLayoutPosition());
        mDatas.add(0, remove);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

        // 显示的个数  4个
//        mItemCount = recyclerView.getChildCount();
//
//        for (int i = 0; i < mItemCount; i++) {
//            View childAt = recyclerView.getChildAt(i);
//
//            mV = 1 - (float) ((mItemCount - i) / (mItemCount * 2.0));
//            mTranslateY = (mItemCount - i) * DEFAULT_SPACE;
//            Log.d("level ", "v= " + mV + "itcount= " + mItemCount + " i= " + i);
//            Log.d("level=", " mTranslateY= " + mTranslateY);
//            childAt.setScaleX(mV);
//            childAt.setScaleY(mV);
//            childAt.setTranslationY(mTranslateY);
//        }

        double maxDistance = recyclerView.getWidth() * 0.5f;
        double fraction = dX / maxDistance;

        if (fraction > 1) {
            fraction = 1;
        }

        // 显示的个数  4个
        int itemCount = recyclerView.getChildCount();
        Log.d("gh", "itemCount= " + itemCount);
        for (int i = 0; i < itemCount; i++) {
            View view = recyclerView.getChildAt(i);

            // 此处是实现 当View左右滑动过程中 View 子View 的布局位置,实现动画效果, 此处需要计算 ,
            if (i == itemCount - 1) {
                view.setScaleX(1.0f);
                view.setScaleY(1.0f);
            } else {
                view.setScaleX(1 - ((itemCount - i) * 0.05f));
                view.setScaleY(1 - ((itemCount - i) * 0.05f));
                view.setTranslationY((itemCount - i) * 80);
            }
        }
    }
}
