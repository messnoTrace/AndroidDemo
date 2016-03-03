package com.notrace;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by notrace on 2016/3/3.
 */
public class RotateView extends View {

    private int progress=0;

    private RectF mRectF;

    private int paintColor= Color.parseColor("#57C7FF");
    private Paint mPaint;

    private static final float startAngle = -90;

    public RectF getRectF() {
        return mRectF;
    }

    public void setRectF(RectF mRectF) {
        this.mRectF = mRectF;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }


    public RotateView(Context context) {
        super(context);
        init();
    }

    public RotateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RotateView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(mRectF,startAngle,-360,true,mPaint);
    }

    private void init(){

        mPaint = new Paint();
        mPaint.setColor(paintColor);
        mPaint.setAlpha(0xCC);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(20);
        mPaint.setStyle(Paint.Style.STROKE);
    }


}
