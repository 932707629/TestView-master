package com.chuangdu.testview;

import android.content.Context;

/**
 * Created by SouShin on 2018/1/30.
 */

public class Utils {

    public static int dp2px(Context context,float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int sp2px(Context context,float spValue) {
        float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scale + 0.5f);
    }

}
