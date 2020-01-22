package com.example.abhishekkumar.exchangedata;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button bt1;
    public static final int Req_Code=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.firstET);
        bt1=(Button)findViewById(R.id.firstBt);



    }

    public void click1(View view) {
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("First",et1.getText().toString());
        startActivityForResult(intent,Req_Code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==Req_Code && resultCode==RESULT_OK){
            et1.setText(data.getStringExtra("Second"));
        }
    }
}
