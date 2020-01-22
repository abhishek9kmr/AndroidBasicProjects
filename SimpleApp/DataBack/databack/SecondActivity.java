package com.example.abhishekkumar.databack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ed=(EditText)findViewById(R.id.editText);

    }

    @Override
    public void onBackPressed() {
        Intent i=new Intent();
        i.putExtra("message",ed.getText().toString());
        setResult(RESULT_OK,i);
        finish();
    }
}
