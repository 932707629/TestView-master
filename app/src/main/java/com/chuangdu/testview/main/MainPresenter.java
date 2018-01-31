package com.chuangdu.testview.main;

/**
 * Created by Administrator on 2017/12/25.
 */

public class MainPresenter implements MainContract.Presenter{
    private MainContract.View mainView;
    public MainPresenter(MainContract.View v){
        this.mainView=v;
    }

    @Override
    public void subcribe() {
        mainView.initData();
    }

    @Override
    public void unsubcribe() {

    }
}
