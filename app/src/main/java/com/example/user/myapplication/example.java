package com.example.user.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class example extends AppCompatActivity {

    private Button calbtn, playerbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        init();
    }
    private void init() {
        calbtn = findViewById(R.id.calcBtn);
        calbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(example.this, "계산기", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(example.this, TwoActivity.class);
                startActivity(intent);

            }
        });

        playerbtn = findViewById(R.id.playerBtn);
        playerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(example.this, "플레이어", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(example.this, ThreeActivity.class);
                startActivity(intent);
            }
        });
    }
}
