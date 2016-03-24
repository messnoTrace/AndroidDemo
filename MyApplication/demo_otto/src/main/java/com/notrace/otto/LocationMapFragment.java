package com.notrace.otto;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.otto.Subscribe;

import java.net.URL;

/**
 * Created by notrace on 2016/3/24.
 */
public class LocationMapFragment extends Fragment {
    private static final String URL =
            "https://maps.googleapis.com/maps/api/staticmap?sensor=false&size=400x400&zoom=13&center=%s,%s";



    private DownloadTask downloadTask;
    private ImageView imageView;

    @Override
    public void onResume() {
        super.onResume();
        BusProvider.getInstance().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        BusProvider.getInstance().unregister(this);
        if(downloadTask!=null)
        {
            downloadTask.cancel(true);
            downloadTask=null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        imageView=new ImageView(getActivity());
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);

        return imageView;
    }


    @Subscribe
    public void onLocationChanged(LocationChangeEvent event)
    {
        if (downloadTask != null) {
            downloadTask.cancel(true);
        }

        // Trigger a background download of an image for the new location.
        downloadTask = new DownloadTask();
        downloadTask.execute(String.format(URL, event.lat, event.lon));
    }

    @Subscribe public void onImageAvailable(ImageAvailableEvent event){
        if(imageView!=null)
        {
            imageView.setImageDrawable(event.image);
        }
    }

    private static  class ImageAvailableEvent{
        public final Drawable image;
        ImageAvailableEvent(Drawable image)
        {
            this.image=image;
        }
    }

    private static class DownloadTask extends AsyncTask<String,Void,Drawable>
    {

        @Override
        protected Drawable doInBackground(String... params) {
            try
            {
                return BitmapDrawable.createFromStream(new URL(params[0]).openStream(),"bitmap.jpg");
            }catch (Exception e)
            {

                return null;
            }
        }

        @Override
        protected void onPostExecute(Drawable drawable) {
            if(!isCancelled()&&drawable!=null)
            {
                BusProvider.getInstance().post(new ImageAvailableEvent(drawable));
            }
        }
    }
}

