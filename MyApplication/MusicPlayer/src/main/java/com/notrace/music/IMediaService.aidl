// IMediaService.aidl
package com.notrace.music;

// Declare any non-default types here with import statements

import android.graphics.Bitmap;
import com.notrace.music.model.MusicInfo;


interface IMediaService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);


                boolean play(int pos);
                boolean playById(int id);
                boolean rePlay();
            	boolean pause();
            	boolean prev();
            	boolean next();
            	int duration();
                int position();
                boolean seekTo(int progress);


                void refreshMusicList(in List<MusicInfo> musicList);
                void getMusicList(out List<MusicInfo> musicList);

                int getPlayState();
                int getPlayMode();
                void setPlayMode(int mode);
                void sendPlayStateBrocast();
                void exit();
                int getCurMusicId();
                void updateNotification(in Bitmap bitmap, String title, String name);
                void cancelNotification();
                MusicInfo getCurMusic();

}
