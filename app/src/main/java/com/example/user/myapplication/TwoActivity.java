package com.example.user.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        setTitle(R.string.calcTitle);
        getSupportActionBar().setTitle("계산기");
        firstet = findViewById(R.id.firstet);
        firstet.setShowSoftInputOnFocus(false);
        secondet = findViewById(R.id.secondet);
        secondet.setShowSoftInputOnFocus(false);
        firsttv = findViewById(R.id.firsttv);
        secondtv = findViewById(R.id.secondtv);
        calcbtnResult = findViewById(R.id.btnResult);

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

    private int intParseFromString(String v) {
        int result = -1;
        try {
            result = Integer.parseInt(v);
        } catch(Exception e) {
            return result;
        }
        return result;
    }

    private String doCalc(String v1, String v2, String symbol) {
        String result = "";
        int intV1 = intParseFromString(v1);
        int intV2 = intParseFromString(v2);

        switch (symbol) {
            case "+" :
                result = Integer.toString(intV1 + intV2);
                break;
            case "-" :
                result = Integer.toString(intV1 - intV2);
                break;
            case "/" :
                if(intV2 == 0) {
                    result = "DIV0";
                } else {
                    result = Double.toString((double)intV1 / intV2);
                }

                break;
            case "*" :
                result = Integer.toString(intV1 * intV2);
                break;
        }
        return(result);
    }
    //숫자 버튼 이벤트
    public void clkNoBtn(View v) {
        Log.i("test", "이벤트 연결 성공");
        String calcSymbol = firsttv.getText().toString();

        if (v.getId() == R.id.btnResult) {
            String val1 = firstet.getText().toString();
            String val2 = secondet.getText().toString();
            if(calcSymbol.equals("") || val1.equals("") || val2.equals("")) {
                secondtv.setText("incomplete");
            } else {
                String result = doCalc(val1, val2, calcSymbol);
                secondtv.setText(result);
            }
        } else {
            EditText target = null;
            if (calcSymbol.equals("")) {
                target = firstet;
            } else {
                target = secondet;
                // secondet.requestFocus();
            }

            if (target != null) {

                if (v instanceof Button) {
                    //누른 버튼의 텍스트 값
                    Button b = (Button) v;
                    String pressNo = b.getText().toString();

                    //기존에 있던 텍스트 값 + 누른 버튼의 텍스트 값
                    String existValue = target.getText().toString();
                    existValue += pressNo;

                    //합친 텍스트 값을 다시 타겟에 입력
                    target.setText(existValue);
                }
            }
        }
    }


    public void clkLeftBtn(View v) {
        Log.i("test","이벤트 연결 성공");
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
                if(firstet.getText().toString().equals("")) {
                    secondtv.setText("incomplete");
                } else if(secondet.getText().toString().equals("")) {
                    secondtv.setText("incomplete");
                } else if(firstet.getText().toString().equals("") && secondet.getText().toString().equals("")) {
                    secondtv.setText("incomplete");
                }  else {
                    int n1 = Integer.parseInt(str);
                    int n2 = Integer.parseInt(str2);
                    int result;
                    if (firsttv.getText().toString().equals("+")) {
                        result = n1 + n2;
                        secondtv.setText("" + result);
                    } else if (firsttv.getText().toString().equals("-")) {
                        result = n1 - n2;
                        secondtv.setText("" + result);
                    } else if (firsttv.getText().toString().equals("/")) {
                        Double d1 = Double.parseDouble(str);
                        Double d2 = Double.parseDouble(str2);
                        if(firstet.getText().toString().equals("0") || secondet.getText().toString().equals("0")) {
                            secondtv.setText("DIV0");
                        } else {
                            Double divResult = Double.parseDouble(String.format("%.3f",(d1/d2)));

                            secondtv.setText(""+divResult);
                        }
                    } else {
                        result = n1 * n2;
                        secondtv.setText("" + result);
                    }
                }
            }
        }
    }

}
