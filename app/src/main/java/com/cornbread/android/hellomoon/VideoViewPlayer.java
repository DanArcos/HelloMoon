package com.cornbread.android.hellomoon;

import android.app.Activity;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.widget.VideoView;

public class VideoViewPlayer extends Activity{
    VideoView mVideoView;
    MediaController mMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoviewplayer);

        mVideoView = (VideoView) findViewById(R.id.video_player_view);
        mVideoView.setVideoPath("android.resource://com.cornbread.android.hellomoon/raw/apollo17stroll");

        mVideoView.start();


    }
}
