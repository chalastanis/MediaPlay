package com.example.mediaplay;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button mediaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer=new MediaPlayer();
        mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.ichotopia_choris_tachitita);

        mediaButton = findViewById(R.id.mediaButton);
        mediaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    pauseMusic();
                }else{
                    playMusic();
                }
            }
        });
    }


    public void pauseMusic() {
        if(mediaPlayer != null){
            mediaPlayer.pause();
            mediaButton.setText(R.string.button_play);
        }
    }

    public void playMusic() {
        if(mediaPlayer != null){
            mediaPlayer.start();
            mediaButton.setText(R.string.button_pause);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.pause();
            mediaPlayer.release();
            mediaButton.setText(R.string.button_play);
        }
    }
}