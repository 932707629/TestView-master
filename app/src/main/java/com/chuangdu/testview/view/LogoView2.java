package com.chuangdu.testview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by SouShin on 2018/1/30.
 */

public class LogoView2 extends View {

    private int mStars= Color.parseColor("#d42a26");
    private Paint mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath=new Path();
    public LogoView2(Context context) {
        super(context);
        initView();
    }

    public LogoView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LogoView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(mStars);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.moveTo(300,100);
        mPath.lineTo(230,240);
        mPath.lineTo(295,210);
        mPath.lineTo(360,240);
        mPath.close();
        canvas.drawPath(mPath,mPaint);


    }
}
