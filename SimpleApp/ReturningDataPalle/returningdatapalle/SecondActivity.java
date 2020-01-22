package com.example.abhishekkumar.returningdatapalle;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
    }
    //STEP 3- RESPONSE TO FIRST SCREEN
    public void clicked1(View view) {
        setResult(RESULT_OK);
        finish();
    }
    //STEP 3- RESPONSE TO FIRST SCREEN
    public void clicked2(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }


}
