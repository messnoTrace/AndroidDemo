package com.notrace;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;


/**
 * Created by notrace on 2016/3/3.
 */
public class PathView extends View implements ValueAnimator.AnimatorUpdateListener{

    Paint mPaint;
    Path mPath;
    int mStrokeColor;
    float mStrokeWidth;

    float mPathLength = 0f;

    private float[]mCurrentPosition=new float[2];

    private PathMeasure mPathMeasure;
    private Object mObject;


    private long mCurrentPlayTime=0l;

    ValueAnimator valueAnimator;
    public PathView(Context context) {
        this(context, null);
        init();
    }

    public PathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public PathView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.PathView);
        mStrokeColor = a.getColor(R.styleable.PathView_strokeColor, 0xff00ff00);
        mStrokeWidth = a.getFloat(R.styleable.PathView_strokeWidth, 8.0f);
        a.recycle();
        init();
    }

    private void init(){

        mObject=new Object();
        mPaint = new Paint();
        mPaint.setColor(mStrokeColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setAntiAlias(true);

        Path path=new Path();
//        path.addCircle(500,500,100, Path.Direction.CW);
//        setPath(path);
    }

    public void setPath(Path p){
         mPath = p;
         mPathMeasure = new PathMeasure(mPath, false);

         mPathLength = mPathMeasure.getLength();
    }


    public void setPath(float x,float y,float radius){
        mPath=new Path();
        mPath.addCircle(x,y,radius, Path.Direction.CW);
        mPathMeasure = new PathMeasure(mPath, false);

        mPathLength = mPathMeasure.getLength();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mCurrentPosition[0], mCurrentPosition[1], 10, mPaint);

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(widthMeasureSpec);

        int measuredWidth, measuredHeight;

        if(widthMode == MeasureSpec.AT_MOST)
            throw new IllegalStateException("AnimatedPathView cannot have a WRAP_CONTENT property");
        else
            measuredWidth = widthSize;

        if(heightMode == MeasureSpec.AT_MOST)
            throw new IllegalStateException("AnimatedPathView cannot have a WRAP_CONTENT property");
        else
            measuredHeight = heightSize;

        setMeasuredDimension(measuredWidth, measuredHeight);
    }


    public int getPathColor() {
        return mPaint.getColor();
    }
    public void setPathColor(final int color) {
        mPaint.setColor(color);
    }
    public float getPathWidth() {
        return mPaint.getStrokeWidth();
    }

    public void setPathWidth(final float width) {
        mPaint.setStrokeWidth(width);
    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        float value = (Float) animation.getAnimatedValue();
        // 获取当前点坐标封装到mCurrentPosition
        mPathMeasure.getPosTan(value, mCurrentPosition, null);
        postInvalidate();
    }



    public  void startAnimation(long duration)
    {
        valueAnimator = ValueAnimator.ofFloat(0, mPathMeasure.getLength());
        valueAnimator.setDuration(duration);
        valueAnimator.addUpdateListener(this);
//        valueAnimator.setRepeatCount(2);
    }


    //targetApi(19)
//    public void play()
//    {
//        valueAnimator.start();
//    }
//    public void pause(){
//
//        valueAnimator.pause();
//    }
//
//    public void resuem(){
//        valueAnimator.resume();
//
//    }



    public void start(){
        valueAnimator.start();
        valueAnimator.setCurrentPlayTime(mCurrentPlayTime);
    }

    public void stop()
    {
        mCurrentPlayTime=valueAnimator.getCurrentPlayTime();
        valueAnimator.cancel();
    }
}
