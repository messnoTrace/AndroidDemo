package com.notrace;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity implements View.OnClickListener{

    private PathView pathView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pathView = (PathView) findViewById(R.id.pathView);


        findViewById(R.id.btn_play).setOnClickListener(this);
        findViewById(R.id.btn_pause).setOnClickListener(this);
        findViewById(R.id.btn_continue).setOnClickListener(this);



        pathView.setPath(300, 300, 100);
        pathView.startAnimation(5000);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_play:
//                pathView.play();
                pathView.start();

                break;

            case R.id.btn_pause:
//                pathView.pause();
                pathView.stop();
                break;
            case R.id.btn_continue:
//                pathView.resuem();
                pathView.start();
                break;
        }
    }
}
