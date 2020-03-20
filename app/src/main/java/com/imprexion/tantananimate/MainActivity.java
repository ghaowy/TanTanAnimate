package com.imprexion.tantananimate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.MyTouchHelperCallback;
import com.imprexion.tantananimate.config.DemoAdapter;
import com.imprexion.tantananimate.config.SwipeBean;
import com.imprexion.tantananimate.config.SwipeConfig;
import com.imprexion.tantananimate.config.SwipeLayoutManager;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private DemoAdapter mDemoAdapter;
    private List<SwipeBean> mSwipeBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwipeBeans = SwipeConfig.initData();
        initRecyclerView();

        initData();
    }

    private void initData() {

        mDemoAdapter.setDatas(mSwipeBeans);
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.rv_test);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new SwipeLayoutManager());
        mDemoAdapter = new DemoAdapter(this);
        recyclerView.setAdapter(mDemoAdapter);

        ItemTouchHelper touchHelper = new ItemTouchHelper(new MyTouchHelperCallback(mDemoAdapter, mSwipeBeans));
        touchHelper.attachToRecyclerView(recyclerView);
    }
}
