package com.example.abhishekkumar.returningdatapalle;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   //STEP 1- WRITE THE REQUEST CODE- IT HELPS TO IDENTIFY FROM WHICH INTENT YOU CAME BACK
    public static  final int REQ_CODE_1= 1;
    Button button;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        tv=(TextView)findViewById(R.id.textView);


    }
     //STEP 2- START SECOND SCREEN
    public void clicked(View view) {
        Intent in=new Intent(MainActivity.this,SecondActivity.class);
        startActivityForResult(in,REQ_CODE_1);

    }

    //STEP 4 -  CATCH DATA FROM SECOND SCREEN
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==REQ_CODE_1){
            if (resultCode==RESULT_OK){
                tv.setText("CHILD !:SUCCESS");
            }

            else if (resultCode==RESULT_CANCELED){

                tv.setText("CHILD!:FAILURE");
            }





        }
    }
}
