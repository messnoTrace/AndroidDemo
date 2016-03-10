package com.notrace.drag;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by notrace on 2016/2/2.
 */
public class DragLayout extends LinearLayout {
    private  ViewDragHelper mDragHelper;
    private View mDragView;

    public DragLayout(Context context) {
        super(context);
    }

    public DragLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDragHelper=ViewDragHelper.create(this,1.0f, new ViewDragHelper.Callback() {
            @Override
            public boolean tryCaptureView(View child, int pointerId) {
                return mDragView==child;
            }

                    @Override
                    public int clampViewPositionHorizontal(View child, int left, int dx)
                    {
                        return left;
                    }

                    @Override
                    public int clampViewPositionVertical(View child, int top, int dy)
                    {
                        return top;
                    }


                    //手指释放的时候回调
                    @Override
                    public void onViewReleased(View releasedChild, float xvel, float yvel)
                    {
                        //mAutoBackView手指释放时可以自动回去
//                        if (releasedChild == mAutoBackView)
//                        {
//                            mDragger.settleCapturedViewAt(mAutoBackOriginPos.x, mAutoBackOriginPos.y);
//                            invalidate();
//                        }
                    }

                    //在边界拖动时回调
                    @Override
                    public void onEdgeDragStarted(int edgeFlags, int pointerId)
                    {
//                        mDragger.captureChildView(mEdgeTrackerView, pointerId);
                    }
        }


        );

        mDragHelper.setEdgeTrackingEnabled(ViewDragHelper.EDGE_LEFT);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        final int action = MotionEventCompat.getActionMasked(ev);
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {
            mDragHelper.cancel();
            return false;
        }
        return mDragHelper.shouldInterceptTouchEvent(ev);
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        mDragHelper.processTouchEvent(ev);
        return true;
    }

    @Override
    public void computeScroll()
    {
//        if(mDragHelper.continueSettling(true))
//        {
//            invalidate();
//        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        super.onLayout(changed, l, t, r, b);

//        mAutoBackOriginPos.x = mAutoBackView.getLeft();
//        mAutoBackOriginPos.y = mAutoBackView.getTop();
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();

        mDragView = getChildAt(0);
//        mAutoBackView = getChildAt(1);
//        mEdgeTrackerView = getChildAt(2);
    }
}
