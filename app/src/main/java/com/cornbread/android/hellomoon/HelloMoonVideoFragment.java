package com.cornbread.android.hellomoon;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.IOException;

public class HelloMoonVideoFragment extends Fragment {
    private MediaPlayer mVideoPlayer;

    private SurfaceView mSurfaceView;
    private SurfaceHolder mSurfaceHolder;

    private Button mPlayButton;
    private Button mStopButton;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hello_moon_video, parent, false);

        mVideoPlayer = new MediaPlayer();

        mSurfaceView = (SurfaceView) v.findViewById(R.id.surface_view);

        mSurfaceHolder = mSurfaceView.getHolder();
        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Log.d("TAG", "Surface created!");

                //mSurfaceHolder = holder;

                Log.d("TAG", (holder == null) + " is true if null");

                mVideoPlayer.setDisplay(holder);
                Log.d("TAG", "Set Display Created!");
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                mVideoPlayer.stop();
                mVideoPlayer.release();
            }
        });


        mPlayButton = (Button) v.findViewById(R.id.hellomoon_playVideo);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Play Video
                //Toast.makeText(getActivity(),"Play",Toast.LENGTH_SHORT).show();
                play();
            }
        });

        mStopButton = (Button) v.findViewById(R.id.hellomoon_stopVideo);
        mStopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Stop Video
                //Toast.makeText(getActivity(),"Stop",Toast.LENGTH_SHORT).show();
                stop();
            }
        });

        return v;
    }

    public void play(){

        try {
            mVideoPlayer.setDataSource(getActivity(), Uri.parse("android.resource://com.cornbread.android.hellomoon/raw/apollo17stroll"));
            mVideoPlayer.prepare();

        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG", "Prepare UnSuccessful");
        }

        mVideoPlayer.start();
        Log.d("TAG", "Start Called");
    }

    public void stop() {
        if (mVideoPlayer != null) {
            mVideoPlayer.stop();
            mVideoPlayer.release();
            mVideoPlayer = null;
        }
    }
}
