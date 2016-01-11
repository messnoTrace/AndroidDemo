package com.notrace.bottomtab.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;

import com.levelmoney.velodrome.Velodrome;

import butterknife.ButterKnife;
import icepick.Icepick;
import nucleus.presenter.Presenter;
import nucleus.view.NucleusAppCompatActivity;

/**
 * Created by notrace on 2015/12/23.
 */
public abstract class BaseActivity<PresenterType extends Presenter> extends NucleusAppCompatActivity<PresenterType>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        injectorPresenter();
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(getLayoutResId());

    }


    @Override
    public void onContentChanged() {
        super.onContentChanged();

        ButterKnife.bind(this);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Velodrome.handleResult(this, requestCode, resultCode, data);
    }

    protected void injectorPresenter() {}

    abstract protected @LayoutRes
    int getLayoutResId();
}
