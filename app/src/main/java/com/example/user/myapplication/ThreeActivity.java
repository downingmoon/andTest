package com.example.user.myapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ThreeActivity extends AppCompatActivity {

    private Button pause;
    private Button stop;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        init();
    }

    private void init() {
        setTitle(R.string.mp3Title);
        pause = findViewById(R.id.pause);
        stop = findViewById(R.id.stop);

    }


    public void clkButtons(View v) {
        if (v instanceof Button) {
            Button b = (Button)v;
            switch (b.getId()) {
                case R.id.song1 :
                    _doStop();
                    Toast.makeText(ThreeActivity.this, "노래1번 재생", Toast.LENGTH_SHORT).show();
                    mp = MediaPlayer.create(ThreeActivity.this,R.raw.song1);
                    mp.start();
                    break;

                case R.id.song2 :
                    _doStop();
                    Toast.makeText(ThreeActivity.this, "노래2번 재생", Toast.LENGTH_SHORT).show();
                    mp = MediaPlayer.create(ThreeActivity.this,R.raw.song2);
                    mp.start();
                    break;

                case R.id.pause :
                    if(mp == null) {
                        Toast.makeText(ThreeActivity.this, "재생중인 노래 없음", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    Button pause = (Button)v;
                    String txt = pause.getText().toString();
                    if(txt.equals(getString(R.string.pause))) {
                        if(mp.isPlaying()) {
                            Toast.makeText(ThreeActivity.this, "일시정지", Toast.LENGTH_SHORT).show();
                            mp.pause();
                            pause.setText(R.string.play);
                        }

                    } else if(txt.equals("재생")) {
                        Toast.makeText(ThreeActivity.this, "재생", Toast.LENGTH_SHORT).show();
                        mp.start();
                        pause.setText(R.string.pause);
                    }
                    break;

                case R.id.stop :
                    _doStop();
                    break;
            }
        }
    }

    private void _doStop() {
        String txt = pause.getText().toString();
        if(mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
        if(txt.equals(getString(R.string.play))) {
            pause.setText(R.string.pause);
        }
    }
}
