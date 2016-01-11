package com.notrace.bottomtab.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.notrace.bottomtab.Api.ProductApi;
import com.notrace.bottomtab.Api.UrlConst;
import com.notrace.bottomtab.R;
import com.notrace.bottomtab.base.LazyFragment;
import com.notrace.bottomtab.entitys.Res_Product;
import com.notrace.bottomtab.presenter.IndexPresenter;

import retrofit.RestAdapter;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;


public class IndexFragment extends LazyFragment<IndexPresenter> {
    private boolean isPrepared;

    @Override
    protected void lazyLoad() {
        if(!isPrepared || !isVisible) {
            return;
        }
        loadData();

//        if (!canLoadData(multiStateView, adapter)) {
//            return;
//        }
//
//        multiStateView.setViewState(VIEW_STATE_LOADING);
//        refreshView.autoRefresh();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_index, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isPrepared = true;
        lazyLoad();
    }

    private void loadData()
    {
        RestAdapter restAdapter=new RestAdapter.Builder()
                .setEndpoint(UrlConst.URL_BASE).build();
        ProductApi api=restAdapter.create(ProductApi.class);
        Observable<Res_Product>observable=api.getProductList("4422cf8c41184e7d");

        observable
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())

        .subscribe(subscriber)
        ;

    }


    Subscriber subscriber=new Subscriber<Res_Product>(){


        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.d("++++++++++++","e"+e.toString());
        }

        @Override
        public void onNext(Res_Product res_product) {

            Log.d("++++++++++++","");
        }
    };

}
