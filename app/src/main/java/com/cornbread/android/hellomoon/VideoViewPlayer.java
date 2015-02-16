package com.cornbread.android.hellomoon;

import android.app.Activity;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class VideoViewPlayer extends Activity{
    VideoView mVideoView;
    Button mPlayButton;
    Button mPauseButton;
    Button mStopButton;

    Boolean isPaused = false;
    Boolean isStopped = true;

    MediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoviewplayer);

        mVideoView = (VideoView) findViewById(R.id.video_player_view);
        mVideoView.setVideoPath("android.resource://com.cornbread.android.hellomoon/raw/apollo17stroll");

        mPlayButton = (Button)findViewById(R.id.VideoView_Play);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isStopped){
                    isStopped = false;
                    mVideoView.start();
                    mVideoView.resume();
                    }

                else{
                    if(isPaused){
                        isPaused = false;
                        mVideoView.start();
                    }
                }


            }
        });

        mPauseButton = (Button)findViewById(R.id.VideoView_Pause);
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mVideoView.pause();
                isPaused = true;
            }
        });

        mStopButton = (Button)findViewById(R.id.VideoView_Stop);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isStopped = true;
                mVideoView.stopPlayback();
            }
        });


    }
}
