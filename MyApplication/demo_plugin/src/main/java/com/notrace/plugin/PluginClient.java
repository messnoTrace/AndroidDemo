package com.notrace.plugin;

import android.util.Log;

/**
 * Created by notrace on 2016/1/20.
 */
public class PluginClient {

    public PluginClient(){
        Log.d("==============PluginClient","PluginClient initial");
    }

    public int f1(int a, int b) {
        return a+b;
    }
}
