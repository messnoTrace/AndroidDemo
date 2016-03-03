package com.notrace;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;


public class MainActivity extends Activity {

    private PathView1 pathView;

    private   RotateView rotateView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rotateView= (RotateView) findViewById(R.id.rotateview);


        RectF rectF=new RectF(500,500,520,520);
        rotateView.setRectF(rectF);


//        pathView = (PathView1) findViewById(R.id.pathView);
//        Path path=new Path();
//        path.addCircle(300,300,50, Path.Direction.CW);
//        pathView.setPath(path);
//
//
//        pathView.getPathAnimator()
//                .delay(1000)
//                .duration(50000)
//                .animationListener(mListener)
//                .interpolator(new AccelerateDecelerateInterpolator())
//                .start();
    }

//    public Animator.AnimatorListener mListener=new Animator.AnimatorListener() {
//        @Override
//        public void onAnimationStart(Animator animation) {
//
//        }
//
//        @Override
//        public void onAnimationEnd(Animator animation) {
//
//        }
//
//        @Override
//        public void onAnimationCancel(Animator animation) {
//
//        }
//
//        @Override
//        public void onAnimationRepeat(Animator animation) {
//
//        }
//    };


}
