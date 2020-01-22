package com.example.abhishekkumar.newsapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    ImageView img;
    TextView tv1,tv2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        img=(ImageView)findViewById(R.id.imageView);
        tv1=(TextView)findViewById(R.id.title);
        tv2=(TextView)findViewById(R.id.description);
        b=(Button)findViewById(R.id.button);

        int i=getIntent().getIntExtra("POSITION",0);
        //FOR LOADING IMAGE
        String st= getIntent().getStringExtra("IMAGE");
        Picasso.get().load(String.valueOf(st)).into(img);
        tv1.setText(getIntent().getStringExtra("TITLE"));
        tv2.setText(getIntent().getStringExtra("DESCRIPTION"));
        
        Log.d("POSITION"," "+i);
        Toast.makeText(this, ""+ i, Toast.LENGTH_SHORT).show();
    }

    public void clicked(View view) {


        Intent intent=new Intent(getApplicationContext(),WebActivity.class);
        String urlWeb=getIntent().getStringExtra("URLWEB");
        intent.putExtra("WEBURL",urlWeb);
        startActivity(intent);
    }
}
