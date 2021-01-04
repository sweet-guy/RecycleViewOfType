package com.wdcloud.recycleviewoftype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.NestedScrollAgentWebView;

public class OnlineWebView extends AppCompatActivity {
    //TODO :注意world后缀大写才可以加载
    //使用在线文档链接
    private String realUrl="xxxx.DOC";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_web_view);
        LinearLayout webView =findViewById(R.id.agent_parent);
        NestedScrollAgentWebView scrollAgentWebView= new NestedScrollAgentWebView(this);
        AgentWeb.with(this)
                .setAgentWebParent(webView, new LinearLayout.LayoutParams(-1, -1))//传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
                .useDefaultIndicator()
                .setWebView(scrollAgentWebView)// 使用默认进度条
                .createAgentWeb()//
                .ready()
                .go("http://view.officeapps.live.com/op/view.aspx?src="+realUrl);
    }
}
