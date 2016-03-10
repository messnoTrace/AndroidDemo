package notrace.demo_mvp.base;

import android.os.Bundle;

import icepick.Icepick;
import nucleus.presenter.RxPresenter;

/**
 * Created by notrace on 2016/3/10.
 */
public class BaseRxPresenter<View> extends RxPresenter<View> {
    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        Icepick.restoreInstanceState(this,savedState);
    }

    @Override
    protected void onSave(Bundle state) {
        super.onSave(state);
        Icepick.saveInstanceState(this,state);
    }
}
