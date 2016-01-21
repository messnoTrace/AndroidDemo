package com.notrace.host;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.lang.reflect.Method;
import java.util.List;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            useDexCalssLoader(view);

            }
        });
    }


    private void useDexCalssLoader(View view)
    {
        Intent intent=new Intent("com.notrace.plugin",null);
        PackageManager pm=getPackageManager();
        List<ResolveInfo>plugins=pm.queryIntentActivities(intent, 0);
        ResolveInfo info=plugins.get(0);
        ActivityInfo activityInfo=info.activityInfo;
        String div=System.getProperty("path.separator");
        String packageName=activityInfo.packageName;
        String dexPath=activityInfo.applicationInfo.sourceDir;
        String dexOutputDir=getApplicationInfo().dataDir;
        String libPath=activityInfo.applicationInfo.nativeLibraryDir;
        DexClassLoader classLoader=new DexClassLoader(dexPath,dexOutputDir,libPath,this.getClass().getClassLoader());

        try
        {
            Class<?>clazz=classLoader.loadClass(packageName+".PluginClient");
            Object object=clazz.newInstance();
//             Conn object= (Conn) clazz.newInstance();
            Class[]params=new Class[2];
            params[0]=Integer.TYPE;
            params[1]=Integer.TYPE;
            Method action=clazz.getMethod("f1",params);
            Integer ret= (Integer) action.invoke(object,12,34);

//            Integer ret=object.f1(12,34);
            Snackbar.make(view, "result from plugin is:"+ret, Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }catch (Exception e)
        {

            Log.d("=====",e.toString());
        }
    }
}
