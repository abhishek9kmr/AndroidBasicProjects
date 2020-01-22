package com.example.abhishekkumar.exchangedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText et2;
    Button bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et2=(EditText)findViewById(R.id.secondET);
        bt2=(Button)findViewById(R.id.secondBt);
        et2.setText(getIntent().getStringExtra("First"));
    }
// SEND DATA TO FIRST SCREEN
    public void click2(View view) {
        Intent in=new Intent();
        in.putExtra("Second",et2.getText().toString());
        setResult(RESULT_OK,in);
        finish();
    }
}
