package com.taufique.beatingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.beeptone);
        mediaPlayer.setLooping(true);

        ImageView gifView=findViewById(R.id.imageView);

        Glide.with(this)
                .load(R.raw.beep)
                .into(gifView);

    }
    @Override
    protected void onResume(){
        super.onResume();
        if(mediaPlayer==null){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.beeptone);
            mediaPlayer.setLooping(true);


        }
        mediaPlayer.start();

    }


    @Override
    protected void onPause() {
        super.onPause();
       mediaPlayer.pause();

    }
    @Override
    protected void onStop(){
        super.onStop();
        mediaPlayer.stop();

        mediaPlayer.release();
        mediaPlayer = null;

    }
}
