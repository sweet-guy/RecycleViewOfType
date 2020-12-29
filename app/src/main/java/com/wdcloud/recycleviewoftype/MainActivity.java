package com.wdcloud.recycleviewoftype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyTypeAdapter;
import RecycleViewutil.BaseQuickAdapter;
import RecycleViewutil.animation.ScaleAnimation;
import bean.SectionMultipleItem;
import bean.User;

public class MainActivity extends AppCompatActivity {
    List<SectionMultipleItem> list = new ArrayList<>();
    private MyTypeAdapter myTypeAdapter;
    private SmartRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        RecyclerView recyclerView = findViewById(R.id.RecycleView);
        refreshLayout = findViewById(R.id.refreshLayout);
        myTypeAdapter = new MyTypeAdapter(this,list);
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                getData();
                refreshlayout.finishLoadmore();
                myTypeAdapter.notifyLoadMoreToLoading();
            }
        });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myTypeAdapter.openLoadAnimation(new ScaleAnimation());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myTypeAdapter);
        myTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                SectionMultipleItem data=(SectionMultipleItem)adapter.getData().get(position);
                String name = data.getUser().getName();
                Toast.makeText(MainActivity.this,"第"+position+"个条目"+"数据为："+name,Toast.LENGTH_LONG).show();
            }
        });
        myTypeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                SectionMultipleItem data=(SectionMultipleItem)adapter.getData().get(position);
                String name = data.getUser().getName();
                switch (view.getId())
                {
                    case R.id.in_img:
                        Toast.makeText(MainActivity.this,"点击左边第"+position+"个图片"+"数据为："+name,Toast.LENGTH_LONG).show();
                        break;
                    case R.id.in_text:
                        Toast.makeText(MainActivity.this,"点击左边第"+position+"个文字"+"数据为："+name,Toast.LENGTH_LONG).show();
                        break;
                    case R.id.out_img:
                        Toast.makeText(MainActivity.this,"点击右边第"+position+"个图片"+"数据为："+name,Toast.LENGTH_LONG).show();
                        break;
                    case R.id.out_text:
                        Toast.makeText(MainActivity.this,"点击右边第"+position+"个文字"+"数据为："+name,Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

    private void getData() {
        for (int i = 0; i <10; i++) {
            if(i%2==0)
            {
                User user = new User("左边数据"+i,0);
                SectionMultipleItem sectionMultipleItem = new SectionMultipleItem(0, user);
                list.add(sectionMultipleItem);
            }
            else
            {
                User user = new User("右边数据"+i,1);
                SectionMultipleItem sectionMultipleItem = new SectionMultipleItem(1, user);
                list.add(sectionMultipleItem);
            }
        }
    }
}
