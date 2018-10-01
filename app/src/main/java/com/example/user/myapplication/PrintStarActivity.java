package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class PrintStarActivity extends AppCompatActivity {
    private EditText et;
    private Button btn;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_star);
        getSupportActionBar().setTitle("PrintStar");
        init();
    }

    private int checkInteger(String v) {
        int result = 0;
        try {
            result = Integer.parseInt(v);
        } catch (Exception e) { }
        return result;
    }

    private void init() {
        et = findViewById(R.id.editText1);
        btn = findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = et.getText().toString();
                int num = checkInteger(value);

                if(num > 0) {
                    String result = "";
                    for (int i = 1; i <= num ; i++) {
                        for(int j = 0; j < i; j++) {
                            result += "*";
                        }
                        result += "\n";
                    }
                    tv.setText(result);
                    et.setText("");
                }
            }
        });

        tv = findViewById(R.id.textView1);
    }
}
