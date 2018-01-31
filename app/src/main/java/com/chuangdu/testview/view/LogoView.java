package com.chuangdu.testview.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by SouShin on 2018/1/30.
 */

public class LogoView extends View {
    private Paint mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint pointPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath=new Path();


    private int mAndroid=Color.parseColor("#80c24f");
    private int viewWidth;
    private int viewHeight;
    private int centerWidth;
    private int centerHeight;
    public LogoView(Context context) {
        super(context);
        initData();
    }

    public LogoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public LogoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    private void initData() {
        mPaint.setStyle(Paint.Style.FILL);
        centerHeight=getHeight()/2;
        centerWidth=getWidth()/2;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.viewWidth=getMeasuredWidth();
        this.viewHeight=getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(mAndroid);
        RectF rectF=new RectF(200,100,400,300);
        canvas.drawArc(rectF,-180,180,false,mPaint);

        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(260,160,5,mPaint);
        canvas.drawCircle(340,160,5,mPaint);

        mPaint.setColor(mAndroid);
        mPath.moveTo(200,210);
        mPath.lineTo(400,210);
        mPath.lineTo(400,360);
        mPath.lineTo(200,360);
        mPath.close();
        canvas.drawPath(mPath,mPaint);

        mPaint.setPathEffect(new CornerPathEffect(20));
        mPath.moveTo(200,340);
        mPath.lineTo(400,340);
        mPath.lineTo(400,410);
        mPath.lineTo(200,410);
        mPath.close();
        canvas.drawPath(mPath,mPaint);

        mPath.moveTo(225,410);
        mPath.lineTo(225,490);
        mPath.lineTo(275,490);
        mPath.lineTo(275,410);
        mPaint.setPathEffect(new CornerPathEffect(20));
        canvas.drawPath(mPath,mPaint);

        mPath.moveTo(325,410);
        mPath.lineTo(325,490);
        mPath.lineTo(375,490);
        mPath.lineTo(375,380);

        mPaint.setPathEffect(new CornerPathEffect(20));
        canvas.drawPath(mPath,mPaint);

        RectF rectF1=new RectF(150,210,190,380);
        canvas.drawRoundRect(rectF1,18,18,mPaint);

        RectF rectF2=new RectF(410,210,450,380);
        canvas.drawRoundRect(rectF2,18,18,mPaint);

    }


    public int dp2px(float dpValue) {
        float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }


}
