package com.cornbread.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

public class AudioPlayer {
    private MediaPlayer mPlayer;
    private Boolean mPaused = false;

    public void play(Context c){

        if(isPaused() == false) {
            stop(); //This will destroy any other instances of the media player. We don't want two instances.

            mPlayer = MediaPlayer.create(c, R.raw.one_small_step);

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    stop(); // Call stop once the file is done playing
                }
            });
        }

        mPlayer.start();
        setPaused(false);
    }

    public void pause(){
        if (mPlayer != null){
            mPlayer.pause();
            setPaused(true);
        }
    }

    public void setPaused(Boolean paused){
        mPaused = paused;
    }

    public Boolean isPaused(){
        return mPaused;
    }

    public void stop(){
        if (mPlayer != null){
            mPlayer.release();
            mPlayer = null;
        }

        setPaused(false);
    }
}
