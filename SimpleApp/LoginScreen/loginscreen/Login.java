package com.example.abhishekkumar.loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username,password;
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.name);
        password=(EditText)findViewById(R.id.pass);
        click=(Button)findViewById(R.id.button);
    }

    public void movepage(View view) {

        String stname=username.getText().toString();
        String stpass=password.getText().toString();

        if(stname.equalsIgnoreCase("abhishek")&& stpass.equals("123456"))
        {
            Intent in=new Intent(Login.this,SecondActivity.class);
            startActivity(in);
        }
        else if (stname.equalsIgnoreCase("")|| stpass.equals(""))
        {
            Toast.makeText(getBaseContext(),"Enter Username and Password",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getBaseContext(),"Wrong UserName and Password entered",Toast.LENGTH_SHORT).show();
        }
    }
}
