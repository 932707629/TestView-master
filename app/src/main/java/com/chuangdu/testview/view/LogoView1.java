package com.chuangdu.testview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by SouShin on 2018/1/30.
 */

public class LogoView1 extends View {
    private int mKende= Color.parseColor("#f7cc01");
    private Paint mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    private Path mPath=new Path();
    private int centerWidth;
    private int centerHeight;
    private PorterDuffXfermode mPorterDuffXfermode;
    public LogoView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initData();
    }

    public LogoView1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData();
    }

    public LogoView1(Context context) {
        super(context);
        initData();
    }

    private void initData() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(mKende);
        mPaint.setStrokeWidth(20);
        mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.centerHeight=getMeasuredHeight();
        this.centerWidth=getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.moveTo(100,300);
        mPath.cubicTo(100,300,150,-100,200,280);
        canvas.drawPath(mPath,mPaint);

        mPath.moveTo(210,280);
        mPath.cubicTo(210,280,260,-100,310,300);

        canvas.drawPath(mPath,mPaint);
    }
}
