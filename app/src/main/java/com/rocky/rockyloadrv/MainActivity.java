package com.rocky.rockyloadrv;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.rocky.rockyloadrv.load_rv.RockyLoadRV;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private int pageSize = 10;//每一页的列表项数目

    private int curPageIndex = 1;//当前页数
    private int totalPage = 1;//总页数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RockyLoadRV rv_load = findViewById(R.id.rv_load);
        rv_load.setLayoutManager(new LinearLayoutManager(this));
        final TestAdapter adapter = new TestAdapter();
        rv_load.setAdapter(adapter);
        final List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(String.valueOf(i + 1));
        }
        adapter.setData(list);
        if (adapter.getItemCount()<pageSize) {
            rv_load.setPullLoadEnable(false);
        }else {
            rv_load.setPullLoadEnable(true);
        }

        rv_load.setRockyLoadListener(new RockyLoadRV.RockyLoadListener() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<String> list1= new ArrayList<>();
                        for (int i = 0; i < 10; i++) {
                            list1.add("加载"+String.valueOf(i + 1));
                        }
                        adapter.addAll(list1);
                        //如果正在加载，则获取数据后停止加载动画
                        if(rv_load.ismPullLoading()){
                            rv_load.stopLoadMore();//停止加载动画
                        }
                    }
                },2000);


            }
        });
    }
}
