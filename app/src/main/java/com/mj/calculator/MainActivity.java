package com.mj.calculator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

enum Operate {
    NONE, SQUARE, DIVIDE, MULTIPLY, DECREASE, INCREASE
}

public class MainActivity extends Activity implements View.OnClickListener {
    private int[] bt_id = new int[]{R.id.bt_ac, R.id.bt_square, R.id.bt_percent,
            R.id.bt_divide, R.id.bt_multiply, R.id.bt_dec, R.id.bt_inc, R.id.bt_equal, R.id.bt_dot,
            R.id.bt_0, R.id.bt_1, R.id.bt_2, R.id.bt_3, R.id.bt_4,
            R.id.bt_5, R.id.bt_6, R.id.bt_7, R.id.bt_8, R.id.bt_9};

    private Operate op = Operate.NONE;

    private String show = ""; // 用于保存需要显示的文字
    private String num1 = "";
    private String num2 = "";
    private String result = "0";

    private TextView tv_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();
    }

    private void init() {

        tv_num = findViewById(R.id.tv_num);

        for (int id : bt_id) {
            findViewById(id).setOnClickListener(this);
        }

        findViewById(R.id.bt_rate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, RateActivity.class);
                startActivity(i);
            }
        });

    }

    private Double getNum(String show) {
        return Double.parseDouble(show);
    }

    // 计算平方根
    private String square(String n) {
        Double r = Double.parseDouble(n);
        if(r < 0) {
            return "只能对大于0的数开平方！";
        }
        return String.valueOf(Math.sqrt(r));
    }

    // 计算加法
    private String increase(String n1, String n2) {
        return String.valueOf(Double.parseDouble(n1) + Double.parseDouble(n2));
    }

    // 计算减法
    private String decrease(String n1, String n2) {
        return String.valueOf(Double.parseDouble(n1) - Double.parseDouble(n2));
    }

    // 计算乘法
    private String multiply(String n1, String n2) {
        return String.valueOf(Double.parseDouble(n1) * Double.parseDouble(n2));
    }

    // 计算除法
    private String divide(String n1, String n2) {
        String r = "";
        try {
            r = String.valueOf(Double.parseDouble(n1) / Double.parseDouble(n2));
        } catch (Exception e) {
            r = "请检查输入！";
        }
        return (r);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_ac : {
                tv_num.setText("");
                show = "";
                num1 = "";
                num2 = "";
                break;
            }
            case R.id.bt_square : {
                if(op == Operate.NONE) {
                    show = this.square(show);
                    tv_num.setText(show);
                    show = "";
                }

                break;
            }
            case R.id.bt_percent : {

                break;
            }
            case R.id.bt_divide : {

                break;
            }
            case R.id.bt_multiply : {

                break;
            }
            case R.id.bt_dec : {

                break;
            }
            case R.id.bt_inc : {

                break;
            }
            case R.id.bt_equal : {

                break;
            }
            case R.id.bt_dot : {

                break;
            }
            case R.id.bt_0 : {

                break;
            }
            case R.id.bt_1 : {
                show += "1";
                tv_num.setText(show);
                break;
            }
            case R.id.bt_2 : {
                show += "2";
                tv_num.setText(show);
                break;
            }
            case R.id.bt_3 : {
                show += "3";
                tv_num.setText(show);
                break;
            }
            case R.id.bt_4 : {
                show += "4";
                tv_num.setText(show);
                break;
            }
            case R.id.bt_5 : {
                show += "5";
                tv_num.setText(show);
                break;
            }
            case R.id.bt_6 : {
                show += "6";
                tv_num.setText(show);
                break;
            }
            case R.id.bt_7 : {
                show += "7";
                tv_num.setText(show);
                break;
            }
            case R.id.bt_8 : {
                show += "8";
                tv_num.setText(show);
                break;
            }
            case R.id.bt_9 : {
                show += "9";
                tv_num.setText(show);
                break;
            }
        }
    }
}
