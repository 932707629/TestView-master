package com.chuangdu.testview.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.chuangdu.testview.testview.R;
import com.chuangdu.testview.webview.TestWebActivity;

/**
 * Created by Administrator on 2017/12/25.
 */

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private MainContract.Presenter mainPresenter=new MainPresenter(this);
    private Toolbar toolbar;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter.subcribe();

    }

    @Override
    public void initData() {
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }


}
