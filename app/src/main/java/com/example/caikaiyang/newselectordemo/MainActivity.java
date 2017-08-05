package com.example.caikaiyang.newselectordemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.caikaiyang.newselectordemo.myview.NewSelecterView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private NewSelecterView newselecterview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newselecterview= (NewSelecterView) findViewById(R.id.newselecterview);

        List<String> list=new ArrayList<>();
        list.add("我");
        list.add("你");
        list.add("他");
        list.add("我们");
        list.add("你们");
        list.add("他们");
        list.add("嘻嘻");
        list.add("哈哈");
        list.add("测试");
        list.add("看尚专区");
        list.add("巴拉巴拉");

        newselecterview.setTopic(list);

    }
}
