package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_test1=null, tv_test2=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_test1 = findViewById(R.id.tv_test1);
        tv_test2 = findViewById(R.id.tv_test2);

        int a = R.string.change;

        tv_test1.setText(R.string.change);
        tv_test2.setText("Test2 값 바꾸기");
    }
}
