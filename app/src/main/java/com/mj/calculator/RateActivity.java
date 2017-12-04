package com.mj.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by txiaozhe on 02/12/2017.
 */

public class RateActivity extends Activity {

    private double rate = 6.6137;
    private String[] coins = new String[]{"人民币", "美元"};

    private TextView tv_coin1;
    private TextView tv_coin2;
    private TextView tv_result;

    private double money = 0;
    private EditText et_money;

    private double $toRmb(double $) {
        return $ / rate;
    }

    private double rmbTo$(double r) {
        return r * rate;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        this.init();
    }

    private void init() {
        findViewById(R.id.bt_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RateActivity.this.finish();
            }
        });

        tv_coin1 = findViewById(R.id.tv_coin1);
        tv_coin2 = findViewById(R.id.tv_coin2);
        tv_coin1.setText(coins[0]);
        tv_coin2.setText(coins[1]);
        findViewById(R.id.bt_exchange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p = coins[0];
                coins[0] = coins[1];
                coins[1] = p;
                tv_coin1.setText(coins[0]);
                tv_coin2.setText(coins[1]);
            }
        });

        et_money = findViewById(R.id.et_money);
        tv_result = findViewById(R.id.tv_result);
        findViewById(R.id.bt_calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String m = et_money.getText().toString();
                if(!m.equals("")) {
                    money = Double.parseDouble(m);
                    if(coins[0].equals("人民币")) {
                        tv_result.setText(String.valueOf(money / rate));
                    } else {
                        tv_result.setText(String.valueOf(money * rate));
                    }
                } else {
                    if(coins[0].equals("人民币")) {
                        tv_result.setText(String.valueOf(1 / rate));
                    } else {
                        tv_result.setText(String.valueOf(1 * rate));
                    }
                }
            }
        });
    }
}
