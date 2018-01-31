package com.chuangdu.testview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.chuangdu.testview.Utils;

/**
 * Created by SouShin on 2018/1/27.
 */

public class ProgressView  extends View{

    //边框所在的矩形
    private Paint sidePaint;
    private int sideColor=0xffff3c32;
    private int radius;//圆角半径
    private int sideWidth;
    private int sideHeight;

    private Paint srcPaint;
    private int srcColor=0xffffc6c2;

    private Paint linePaint;

    private int viewWidth;//View的宽
    private int viewHeight;//View的高
    private RectF bgRf;
    private RectF pbRg;
    public ProgressView(Context context) {
        super(context);
        initPaint();
    }



    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaint();
    }

    private void initPaint() {
        sidePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        sidePaint.setStyle(Paint.Style.STROKE);
        sidePaint.setStrokeWidth(Utils.dp2px(getContext(),2));
        sidePaint.setColor(sideColor);

        srcPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        srcPaint.setColor(srcColor);
        srcPaint.setStyle(Paint.Style.FILL);

        linePaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setStrokeWidth(Utils.dp2px(getContext(),1));
        linePaint.setColor(Color.WHITE);

        sideWidth=Utils.dp2px(getContext(),2);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth=getMeasuredWidth();
        viewHeight=getMeasuredHeight();

        radius=viewHeight/2;//圆角半径

        if (bgRf==null){
            bgRf=new RectF(sideWidth,sideWidth,viewWidth-sideWidth,viewHeight-sideWidth);
        }

        if (pbRg==null){
            pbRg=new RectF(sideWidth,sideWidth,viewWidth-Utils.dp2px(getContext(),20),viewHeight-sideWidth);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画边框
        canvas.drawRoundRect(bgRf,radius,radius,sidePaint);

        drawBgSrc(canvas);

        srcPaint.setColor(0x7fff3c32);
        canvas.drawRoundRect(pbRg,radius,radius,srcPaint);

    }

    private void drawBgSrc(Canvas canvas) {
        //画背景
        canvas.drawRoundRect(bgRf,radius,radius,srcPaint);

        for (int x=sideWidth;x<viewWidth;x+= Utils.dp2px(getContext(),15)){
            canvas.drawLine(x,viewHeight-sideWidth,x+Utils.dp2px(getContext(),15),sideWidth,linePaint);
        }
    }




}
