package com.example.abhishekkumar.passingdatasanktips;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tv,tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv=(TextView)findViewById(R.id.textView);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);

        tv.setText("Hello  " +getIntent().getStringExtra("NAME"));
        tv1.setText("Welcome to Sanktips");
        tv2.setText(getIntent().getStringExtra("DESCRIPTION"));
    }
}
