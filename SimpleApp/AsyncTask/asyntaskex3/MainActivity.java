package com.example.abhishekkumar.asyntaskex3;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button bt;
    TextView txt;



    public class MyTask extends AsyncTask<String,Void,String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("B42","1");
        }

        @Override
        protected String doInBackground(String... strings) {
            Log.d("B42","2");
            try {
                URL myurl= new URL(strings[0]);
                HttpURLConnection con=(HttpURLConnection) myurl.openConnection();
                InputStream is=con.getInputStream();
                InputStreamReader ir=new InputStreamReader(is);
                BufferedReader br=new BufferedReader(ir);
                String str= br.readLine();
                StringBuilder sb=new StringBuilder();
                while (str!=null){
                    sb.append(str);
                    str=br.readLine();
                }
                return sb.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            publishProgress();
            return "URL";

        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            Log.d("B42","3");
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("B42","server result="+s);
            txt.setText("server result="+s);
            try {
                JSONArray arr=new JSONArray(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et=(EditText)findViewById(R.id.editText1);
        bt=(Button)findViewById(R.id.button1);
        txt=(TextView) findViewById(R.id.textView1);


    }
    public void clicked(View view) {
        String URL=et.getText().toString();
        MyTask m=new MyTask();
        m.execute(URL);
    }
}
