package com.example.proyecto_nuevo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.MediaController;
import android.widget.VideoView;

public class activity_video extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView mivideo = findViewById(R.id.video1);

        String video = "android.resource://" + getPackageName() + "/" + R.raw.traileriphone14pro;
        Uri uri = Uri.parse(video);

        mivideo.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);

        mivideo.setMediaController(mediaController);

        mediaController.setAnchorView(mivideo);

        Animation animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(1000);
        mivideo.startAnimation(animation);

        mivideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mivideo.start();
            }
        });
    }
}
