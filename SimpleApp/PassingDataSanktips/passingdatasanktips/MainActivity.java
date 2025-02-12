package com.example.abhishekkumar.passingdatasanktips;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    String description="Android Development Tutorial";
    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.editText);
        btn=(Button)findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namevalue = editText.getText().toString();
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("NAME",namevalue);
                intent.putExtra("DESCRIPTION",description);
                startActivity(intent);
            }
        });

    }
}
