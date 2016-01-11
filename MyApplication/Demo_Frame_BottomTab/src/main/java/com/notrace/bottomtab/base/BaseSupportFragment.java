package com.notrace.bottomtab.base;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import icepick.Icepick;
import nucleus.presenter.Presenter;
import nucleus.view.NucleusFragment;

/**
 * Created by notrace on 2015/12/23.
 */
public abstract class BaseSupportFragment<PresenterType extends Presenter> extends NucleusFragment<PresenterType>{

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Icepick.saveInstanceState(this,bundle);

    }



    @Override
    public void onCreate(Bundle bundle) {
        injectorPresenter();
        super.onCreate(bundle);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        ButterKnife.bind(this, view);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    protected void injectorPresenter() {}
}
