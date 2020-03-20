package com.imprexion.tantananimate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.MyDraghHelperCallback;
import com.MyTouchHelperCallback;
import com.imprexion.tantananimate.config.DemoDragAdapter;
import com.imprexion.tantananimate.config.DemoTanTanAdapter;
import com.imprexion.tantananimate.config.SwipeBean;
import com.imprexion.tantananimate.config.SwipeConfig;
import com.imprexion.tantananimate.config.SwipeLayoutManager;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DemoTanTanAdapter mDemoTanTanAdapter;
    private List<SwipeBean> mSwipeBeans;
    private DemoDragAdapter mDragAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwipeBeans = SwipeConfig.initData();
        initRecyclerView();

        initData();
    }

    private void initData() {
        mDragAdapter.setDatas(mSwipeBeans);
//        mDemoTanTanAdapter.setDatas(mSwipeBeans);
    }

    private void initRecyclerView() {
    // 实现探探效果的布局
//        initTanTanRecyclerView();
        initDragDemoRecyclerView();
    }

    private void initDragDemoRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.rv_test);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDragAdapter = new DemoDragAdapter(this);
        recyclerView.setAdapter(mDragAdapter);

        ItemTouchHelper touchHelper = new ItemTouchHelper(new MyDraghHelperCallback(mDragAdapter, mSwipeBeans));
        touchHelper.attachToRecyclerView(recyclerView);
    }

    private void initTanTanRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.rv_test);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new SwipeLayoutManager());
        mDemoTanTanAdapter = new DemoTanTanAdapter(this);
        recyclerView.setAdapter(mDemoTanTanAdapter);

        ItemTouchHelper touchHelper = new ItemTouchHelper(new MyTouchHelperCallback(mDemoTanTanAdapter, mSwipeBeans));
        touchHelper.attachToRecyclerView(recyclerView);
    }
}
