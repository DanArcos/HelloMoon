package com.cornbread.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
    private MediaPlayer mPlayer;

    public void stop(){
        if (mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c){
        stop(); //This will destroy any other instances of the media player. We don't want two instances.

        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            public void onCompletion(MediaPlayer mp){
                stop(); // Call stop once the file is done playing
            }
        });

        mPlayer.start();
    }
}
