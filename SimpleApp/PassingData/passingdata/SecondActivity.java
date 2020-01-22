package com.example.abhishekkumar.passingdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text1=(TextView)findViewById(R.id.textView1);
        text2=(TextView)findViewById(R.id.textView2);
        Bundle bundle=getIntent().getExtras();
        String data1=bundle.getString("uname");
        String data2=bundle.getString("upass");

        text1.setText(data1);
        text2.setText(data2);

    }
}
