package com.chuangdu.testview.main;

/**
 * Created by Administrator on 2017/12/25.
 */

public interface MainContract {
    interface View{
        void initData();
    }
    interface Presenter{
        void subcribe();
        void unsubcribe();
    }
}
