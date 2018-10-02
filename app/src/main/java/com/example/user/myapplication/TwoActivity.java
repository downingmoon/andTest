package com.example.user.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//CalC
public class TwoActivity extends AppCompatActivity {

    private EditText firstet;
    private EditText secondet;
    private TextView firsttv;
    private TextView secondtv;
    private String str = "", str2 = "";
    private Button calcbtnResult;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        init();
    }

    private void init() {
        getSupportActionBar().setTitle("계산기");
        firstet = findViewById(R.id.firstet);
        firstet.setShowSoftInputOnFocus(false);
        secondet = findViewById(R.id.secondet);
        secondet.setShowSoftInputOnFocus(false);
        firsttv = findViewById(R.id.firsttv);
        secondtv = findViewById(R.id.secondtv);
        calcbtnResult = findViewById(R.id.calcbtnResult);

    }


    public void clkRightBtn(View v) {
        if(v instanceof Button) {
            Button b = (Button)v;
            String str3 = b.getText().toString();
            if(str3.equals("C")) {
                firstet.setText("");
                firsttv.setText("");
                secondet.setText("");
                secondtv.setText("");
                firstet.requestFocus();
                str = "";
                str2 = "";
            } else {
                firsttv.setText(str3);
                secondet.setFocusableInTouchMode(true);
                secondet.requestFocus();
            }
        }
    }


    public void clkLeftBtn(View v) {
        if(v instanceof Button) {
            Button b = (Button)v;
            if(b.getText().toString() != calcbtnResult.getText().toString()) {
                if (firsttv.getText().equals("")) {
                    str += b.getText().toString();
                    firstet.setText(str);
                } else {
                    str2 += b.getText().toString();
                    secondet.setText(str2);
                }
            } else {
                int n1 = Integer.parseInt(str);
                int n2 = Integer.parseInt(str2);
                int result;
                if(firsttv.getText().toString().equals("+")) {
                        result = n1 + n2;
                        secondtv.setText("" + result);
                } else if (firsttv.getText().toString().equals("-")) {
                    result = n1 - n2;
                    secondtv.setText(""+ result);
                } else if (firsttv.getText().toString().equals("/")) {
                    Double d1 = Double.parseDouble(str);
                    Double d2 = Double.parseDouble(str2);

                    secondtv.setText(""+ (d1 / d2));
                } else {
                    result = n1 * n2;
                    secondtv.setText(""+ result);
                }
            }
        }
    }

}
