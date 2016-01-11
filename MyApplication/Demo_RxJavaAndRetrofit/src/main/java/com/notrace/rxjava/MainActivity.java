package com.notrace.rxjava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit.RestAdapter;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.btn_main_testnet)
    Button btn_test;
    @Bind(R.id.tv_main_info)
    TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testnet();
            }
        });

    }


    private void testnet()
    {
        Map<String,String>options=new HashMap<>();
        options.put("q","coderrobin");

        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint("https://api.github.com")
                .build();

        GithubService apiService=restAdapter.create(GithubService.class);
        apiService.getTopNewAndroidRepos(options)
        .observeOn(Schedulers.newThread())
        .subscribeOn(AndroidSchedulers.mainThread())
        .flatMap(new Func1<GithubResults, Observable<Repo>>() {
            @Override
            public Observable<Repo> call(GithubResults githubResults) {
                Log.d("=========", githubResults.total_count + "");

                return Observable.from(githubResults.items);
            }
        })

                .map(new Func1<Repo, String>() {
                    @Override
                    public String call(Repo repo) {
                        return repo.url;
                    }
                })
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d("=======","error"+e.toString());
                    }

                    @Override
                    public void onNext(String s) {

                    }
                });

    }
}
