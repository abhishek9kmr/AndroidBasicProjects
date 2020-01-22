package com.example.abhishekkumar.passingdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
    EditText username,password;
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        username=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.password);
        click=(Button)findViewById(R.id.button);
    }

    public void movePage(View view) {

        String stName=username.getText().toString();
        String stPass=password.getText().toString();

        if(stName.equalsIgnoreCase("Abhishek")&& stPass.equals("123456"))
        {
            Intent in=new Intent(LoginScreen.this,SecondActivity.class);
          Bundle bundle=new Bundle();
            bundle.putString("uname",stName);
            bundle.putString("upass",stPass);
            in.putExtras(bundle);
            startActivity(in);
        }
        else if (stName.equalsIgnoreCase(" ")|| stPass.equals(" "))
        {
            Toast.makeText(getBaseContext(),"Enter Username and Password",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Wrong UserName and Password entered",Toast.LENGTH_SHORT).show();
        }
    }
}
