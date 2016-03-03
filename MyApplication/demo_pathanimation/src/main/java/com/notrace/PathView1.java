package com.notrace;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;


/**
 * Created by notrace on 2016/3/3.
 */
public class PathView1 extends View implements ValueAnimator.AnimatorUpdateListener{

    Paint mPaint;
    Path mPath;
    int mStrokeColor;
    float mStrokeWidth;

    float mProgress = 0f;
    float mPathLength = 0f;

    private PathMeasure mPathMeasure;
    private AnimatorBuilder animatorBuilder;
    private Object mObject;

    public PathView1(Context context) {
        this(context, null);
        init();
    }

    public PathView1(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public PathView1(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs,R.styleable.PathView1);
        mStrokeColor = a.getColor(R.styleable.PathView1_strokeColor, 0xff00ff00);
        mStrokeWidth = a.getFloat(R.styleable.PathView1_strokeWidth, 8.0f);
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

        setPath(new Path());
    }

    public void setPath(Path p){
         mPath = p;
         mPathMeasure = new PathMeasure(mPath, false);

         mPathLength = mPathMeasure.getLength();
        updatePathsPhaseLocked();
    }


    public void setPercentage(float percentage){
        if(percentage < 0.0f || percentage > 1.0f)
            throw new IllegalArgumentException("setPercentage not between 0.0f and 1.0f");

        mProgress = percentage;

        updatePathsPhaseLocked();
        invalidate();
    }



    private void updatePathsPhaseLocked() {
            // Required only for Android 4.4 and earlier
            mPath.rLineTo(0.0f, 0.0f);
    }
    public void scalePathBy(float x, float y){
        Matrix m = new Matrix();
        m.postScale(x, y);
        mPath.transform(m);
        PathMeasure measure = new PathMeasure(mPath, false);
        mPathLength = measure.getLength();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(mPath,mPaint);

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


    public AnimatorBuilder getPathAnimator() {
        if (animatorBuilder == null) {
            animatorBuilder = new AnimatorBuilder(this);
        }
        return animatorBuilder;
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
        invalidate();
    }

    public static class AnimatorBuilder {

        private int duration = 350;
        private Interpolator interpolator;
        private int delay = 0;
        private final ObjectAnimator anim;

        Animator.AnimatorListener delgateAnimationListener;

        public AnimatorBuilder(PathView1 pathView) {
            this.anim = ObjectAnimator.ofFloat(pathView, "percentage", new float[]{0.0F, 1.0F});
        }

        public PathView1.AnimatorBuilder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public AnimatorBuilder interpolator(Interpolator interpolator) {
            this.interpolator = interpolator;
            return this;
        }

        public AnimatorBuilder delay(int delay) {
            this.delay = delay;
            return this;
        }


        public AnimatorBuilder animationListener(Animator.AnimatorListener listener){
             this.delgateAnimationListener=listener;
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    delgateAnimationListener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    delgateAnimationListener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    delgateAnimationListener.onAnimationCancel(animation);
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    delgateAnimationListener.onAnimationRepeat(animation);
                }
            });
            return this;
        }


        public void start() {
            this.anim.setDuration((long)this.duration);
            this.anim.setInterpolator(this.interpolator);
            this.anim.setStartDelay((long)this.delay);
            this.anim.start();
        }

        public interface ListenerEnd {
            void onAnimationEnd();
        }

        public interface ListenerStart {
            void onAnimationStart();
        }
    }


}
