package com.ks.seal.launcher;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v1 = (TextView) findViewById(R.id.v1);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/huawenxinwei.ttf");
        v1.setTypeface(tf);
    }
}
