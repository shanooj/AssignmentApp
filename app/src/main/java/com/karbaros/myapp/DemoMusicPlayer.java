package com.karbaros.myapp;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;


public class DemoMusicPlayer extends AppCompatActivity {
    //Button play;

    MediaPlayer mediaPlayer;
    SeekBar playProgressBar;
    TextView tvSongPlayingTime;
    TextView tvSongEndTime;

    private double startTime = 0;
    private double finalTime = 0;
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    public static int oneTimeOnly = 0;
    private Handler myHandler = new Handler();

    public void doPlay(View view) {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
            mediaPlayer.start();
            finalTime = mediaPlayer.getDuration();
            startTime = mediaPlayer.getCurrentPosition();
            if (oneTimeOnly == 0) {
                playProgressBar.setMax((int) finalTime);
                oneTimeOnly = 1;
            }
            tvSongEndTime.setText(String.format("%d : %d ",
                    TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    finalTime)))
            );
            tvSongPlayingTime.setText(String.format("%d : %d ",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                    startTime)))
            );
            playProgressBar.setProgress((int) startTime);
            myHandler.postDelayed(upDateSongTime, 100);
        }
    }

    public void doForward (View view) {
        int tempTime = (int) startTime;
        if((tempTime + forwardTime) <= finalTime) {
            startTime += forwardTime;
            mediaPlayer.seekTo((int) startTime);
        } else {

        }

    }
    public void doBackword (View view) {
        int tempTime = (int) startTime;
        if (tempTime - backwardTime > 0) {
            startTime -= backwardTime;
            mediaPlayer.seekTo((int) startTime);
        } else {

        }

    }

    private Runnable upDateSongTime = new Runnable() {
        @Override
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            tvSongPlayingTime.setText(String.format("%d min : %d ", TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime)))
            );
            playProgressBar.setProgress((int) startTime);
            myHandler.postDelayed(this,100);

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_music_player);
        //play = (Button) findViewById(R.id.btPlay);
        //Action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        } // action bar end

        mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.song);
        playProgressBar = (SeekBar) findViewById(R.id.sbPlayProgressBar);
        playProgressBar.setClickable(false);
        tvSongEndTime = (TextView) findViewById(R.id.tvSongEndTime);
        tvSongPlayingTime = (TextView) findViewById(R.id.tvSongPlayingTime);


    }
}
