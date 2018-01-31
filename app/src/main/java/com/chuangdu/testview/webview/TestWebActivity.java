package com.chuangdu.testview.webview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.chuangdu.testview.testview.R;

/**
 * Created by SouShin on 2018/1/24.
 */

public class TestWebActivity extends AppCompatActivity implements View.OnClickListener{

    public static String INTENT_URL="url";
    private WebView webView;
    private ProgressBar progressBar;
    private TextView tvTitle;
    private ImageView imgFinish;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_web);
        initData();
    }

    private void initData() {
        webView=findViewById(R.id.web_view);
        progressBar=findViewById(R.id.progressbar_webview);
        tvTitle=findViewById(R.id.tv_title);
        imgFinish=findViewById(R.id.img_finish);
        imgFinish.setOnClickListener(this);
        WebSettings settings = webView.getSettings();
        settings.setLoadWithOverviewMode(true);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setSupportZoom(true);

        webView.setWebChromeClient(new MyWebChrome());
        webView.setWebViewClient(new MyWebClient());

        webView.loadUrl(getIntentUrl());

    }


    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            finish();
        }
    }

    private class MyWebChrome extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if (TextUtils.isEmpty(title)){
                tvTitle.setText(title);
            }else {
                tvTitle.setText(getString(R.string.app_name));
            }
        }
    }


    private class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view , String url) {
            try {
                if(url.startsWith("weixin://")) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
            } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
                showToasty("抱歉,没有安装该应用");
                return false;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.GONE);
        }
    }

    public void showToasty(String content){
        Toast.makeText(this, content, Toast.LENGTH_SHORT).show();
    }

    public String getIntentUrl(){
        return getIntent().getStringExtra(INTENT_URL);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
