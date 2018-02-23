package com.ks.seal.launcher;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView v1;
    TextView v2;
    TextView v3;
    TextView v4;
    TextView v5;
    TextView v6;
    TextView v7;
    Button vbtn1;
    Button vbtn2;
    Button vbtn3;
    Button vbtn4;
    Button vbtn5;
    Button vbtn6;
    Button vbtn7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v1 = (TextView) findViewById(R.id.v1);
        v2 = (TextView) findViewById(R.id.v2);
        v3 = (TextView) findViewById(R.id.v3);
        v4 = (TextView) findViewById(R.id.v4);
        v5 = (TextView) findViewById(R.id.v5);
        v6 = (TextView) findViewById(R.id.v6);
        v7 = (TextView) findViewById(R.id.v7);
        vbtn1 = (Button) findViewById(R.id.vbtn1);
        vbtn2 = (Button) findViewById(R.id.vbtn2);
        vbtn3 = (Button) findViewById(R.id.vbtn3);
        vbtn4 = (Button) findViewById(R.id.vbtn4);
        vbtn5 = (Button) findViewById(R.id.vbtn5);
        vbtn6 = (Button) findViewById(R.id.vbtn6);
        vbtn7 = (Button) findViewById(R.id.vbtn7);
        vbtn1.setOnClickListener(this);
        vbtn2.setOnClickListener(this);
        vbtn3.setOnClickListener(this);
        vbtn4.setOnClickListener(this);
        vbtn5.setOnClickListener(this);
        vbtn6.setOnClickListener(this);
        vbtn7.setOnClickListener(this);
    }

    private void setTextViewFont(Typeface tf) {
        v1.setTypeface(tf);
        v2.setTypeface(tf);
        v3.setTypeface(tf);
        v4.setTypeface(tf);
        v5.setTypeface(tf);
        v6.setTypeface(tf);
        v7.setTypeface(tf);
    }

    @Override
    public void onClick(View view) {
        Typeface tf;
        switch (view.getId()) {
            case R.id.vbtn1:
                tf = Typeface.createFromAsset(getAssets(), "fonts/huawenxinwei.ttf");
                setTextViewFont(tf);
                break;
            case R.id.vbtn2:
                tf = Typeface.createFromAsset(getAssets(), "fonts/weiruanjianbiaosong.ttf");
                setTextViewFont(tf);
                break;
            case R.id.vbtn3:
                tf = Typeface.createFromAsset(getAssets(), "fonts/vistazhengheiti.ttf");
                setTextViewFont(tf);
                break;
            case R.id.vbtn4:
                tf = Typeface.createFromAsset(getAssets(), "fonts/huawenlishu.ttf");
                setTextViewFont(tf);
                break;
            case R.id.vbtn5:
                tf = Typeface.createFromAsset(getAssets(), "fonts/minifanzhuanshu.ttf");
                setTextViewFont(tf);
                break;
            case R.id.vbtn6:
                tf = Typeface.createFromAsset(getAssets(), "fonts/jingdianfanfangzhuan.ttf");
                setTextViewFont(tf);
                break;
            case R.id.vbtn7:
                tf = Typeface.createFromAsset(getAssets(), "fonts/jinwendazhuanti.ttf");
                setTextViewFont(tf);
                break;
        }
    }
}
