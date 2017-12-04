package com.mj.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
        if (r < 0) {
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
        if(n2.equals("0")) {
            return "请检查输入";
        }
        return String.valueOf(Double.parseDouble(n1) / Double.parseDouble(n2));
    }

    // 计算百分比
    private String percent(String n) {
        if(!n.equals("0") && !n.equals("")) {
            return String.valueOf(Double.parseDouble(n) / 100);
        }

        return n;
    }

    // 设置操作符类型
    private void setOperate(Operate o) {
        op = o;
    }

    // 识别操作符类型是否是+ - * /
    private boolean isOperator() {
        return op != Operate.NONE;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_ac: {
                tv_num.setText("");
                show = "";
                num1 = "";
                num2 = "";
                this.setOperate(Operate.NONE);
                break;
            }
            case R.id.bt_square: {
                if (op == Operate.NONE) {
                    this.setOperate(Operate.SQUARE);
                    show = this.square(show);
                    tv_num.setText(show);
                }

                break;
            }
            case R.id.bt_percent: {
                show = this.percent(show);
                tv_num.setText(show);
                break;
            }
            case R.id.bt_divide: {
                this.setOperate(Operate.DIVIDE);
                num1 = show;
                break;
            }
            case R.id.bt_multiply: {
                this.setOperate(Operate.MULTIPLY);
                num1 = show;
                break;
            }
            case R.id.bt_dec: {
                this.setOperate(Operate.DECREASE);
                num1 = show;
                break;
            }
            case R.id.bt_inc: {
                this.setOperate(Operate.INCREASE);
                num1 = show;
                break;
            }
            case R.id.bt_equal: {
                switch (op) {
                    case INCREASE: {
                        show = this.increase(num1, show);
                        tv_num.setText(show);
                        break;
                    }
                    case DECREASE: {
                        show = this.decrease(num1, show);
                        tv_num.setText(show);
                        break;
                    }
                    case MULTIPLY: {
                        show = this.multiply(num1, show);
                        tv_num.setText(show);
                        break;
                    }
                    case DIVIDE: {
                        show = this.divide(num1, show);
                        tv_num.setText(show);
                        break;
                    }
                    case NONE: {

                    }
                }
                break;
            }
            case R.id.bt_dot: {
                show += ".";
                tv_num.setText(show);
                break;
            }
            case R.id.bt_0: {
                if (!show.equals("") && this.isOperator()) {
                    show = "0";
                    tv_num.setText(show);
                } else {
                    show += "0";
                    tv_num.setText(show);
                }
                break;
            }
            case R.id.bt_1: {
                if (!show.equals("") && this.isOperator()) {
                    show = "1";
                    tv_num.setText(show);
                } else {
                    show += "1";
                    tv_num.setText(show);
                }

                break;
            }
            case R.id.bt_2: {
                if (!show.equals("") && this.isOperator()) {
                    show = "2";
                    tv_num.setText(show);
                } else {
                    show += "2";
                    tv_num.setText(show);
                }
                break;
            }
            case R.id.bt_3: {
                if (!show.equals("") && this.isOperator()) {
                    show = "3";
                    tv_num.setText(show);
                } else {
                    show += "3";
                    tv_num.setText(show);
                }
                break;
            }
            case R.id.bt_4: {
                if (!show.equals("") && this.isOperator()) {
                    show = "4";
                    tv_num.setText(show);
                } else {
                    show += "4";
                    tv_num.setText(show);
                }
                break;
            }
            case R.id.bt_5: {
                if (!show.equals("") && this.isOperator()) {
                    show = "5";
                    tv_num.setText(show);
                } else {
                    show += "5";
                    tv_num.setText(show);
                }
                break;
            }
            case R.id.bt_6: {
                if (!show.equals("") && this.isOperator()) {
                    show = "6";
                    tv_num.setText(show);
                } else {
                    show += "6";
                    tv_num.setText(show);
                }
                break;
            }
            case R.id.bt_7: {
                if (!show.equals("") && this.isOperator()) {
                    show = "7";
                    tv_num.setText(show);
                } else {
                    show += "7";
                    tv_num.setText(show);
                }
                break;
            }
            case R.id.bt_8: {
                if (!show.equals("") && this.isOperator()) {
                    show = "8";
                    tv_num.setText(show);
                } else {
                    show += "8";
                    tv_num.setText(show);
                }
                break;
            }
            case R.id.bt_9: {
                if (!show.equals("") && this.isOperator()) {
                    show = "9";
                    tv_num.setText(show);
                } else {
                    show += "9";
                    tv_num.setText(show);
                }
                break;
            }
        }
    }
}
