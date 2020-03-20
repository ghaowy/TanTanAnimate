package com.imprexion.tantananimate.config;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author : gongh
 * @date : 2020/3/20 13:53
 * @desc : TODO
 */
public class SwipeLayoutManager extends RecyclerView.LayoutManager {
    private int DEFAULT_SPACE = 40;
    private int mItemCount;
    private int mStartSize;
    private int mMeasuredWidth;
    private int mMeasuredHeight;
    private int mWidthSpace;
    private int mHeightSpace;
    private float mV;

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
//        super.onLayoutChildren(recycler, state);
        detachAndScrapAttachedViews(recycler);
        mItemCount = getItemCount();
        mStartSize = 0;
        if (mItemCount < SwipeConfig.showCount) {
            mStartSize = 0;
        } else {
            mStartSize = mItemCount - SwipeConfig.showCount;
        }
        for (int i = mStartSize; i < mItemCount; i++) {
            View childAt = recycler.getViewForPosition(i);
            addView(childAt);
            measureChildWithMargins(childAt, 0, 0);
            mMeasuredWidth = getDecoratedMeasuredWidth(childAt);
            mMeasuredHeight = getDecoratedMeasuredHeight(childAt);
            mWidthSpace = getWidth() - mMeasuredWidth;
            mHeightSpace = getHeight() - mMeasuredHeight;
            layoutDecoratedWithMargins(childAt, mWidthSpace / 2, mHeightSpace / 2, (mWidthSpace / 2) + mMeasuredWidth, (mHeightSpace / 2) + mMeasuredHeight);

            mV = 1 - (float) ((mItemCount - i) / (mItemCount * 2.0));
            Log.d("level ", "v= " + mV + "itcount= " + mItemCount + " i= " + i);
            childAt.setScaleX(mV);
            childAt.setScaleY(mV);
            childAt.setTranslationY((mItemCount - i) * DEFAULT_SPACE);

        }
    }
}
