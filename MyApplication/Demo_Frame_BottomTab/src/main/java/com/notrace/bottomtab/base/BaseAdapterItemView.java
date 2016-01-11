package com.notrace.bottomtab.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.notrace.bottomtab.qualifier.ClickType;

import butterknife.ButterKnife;
import io.nlopez.smartadapters.views.BindableLayout;

/**
 * Created by notrace on 2015/12/23.
 */
public abstract class BaseAdapterItemView <T> extends BindableLayout<T> {
    public BaseAdapterItemView(Context context) {
        super(context);
    }

    public BaseAdapterItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseAdapterItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public BaseAdapterItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onViewInflated() {
        ButterKnife.bind(this);
    }

    public void notifyItemAction(@ClickType int actionId, T theItem, View view) {
        if(this.viewEventListener != null) {
            this.viewEventListener.onViewEvent(actionId, theItem, this.position, view);
        }

    }

    public void notifyItemAction(@ClickType int actionId, View view) {
        this.notifyItemAction(actionId, this.item, view);
    }

    public void notifyItemAction(@ClickType int actionId) {
        this.notifyItemAction(actionId, this.item, this);
    }
}
