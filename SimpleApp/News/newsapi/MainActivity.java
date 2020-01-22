package com.example.abhishekkumar.newsapi;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<ListItem>arrayList;
    String givenurl="https://newsapi.org/v2/top-headlines?country=in&apiKey=";
    String API_KEY="xxxxxxxxxxxxxxxxxx";
    String URLresult=givenurl+API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Welcome to Abhishek's News", Toast.LENGTH_SHORT).show();


        MyTask m=new MyTask();
        m.execute(URLresult);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        arrayList=new ArrayList<>();


    }
    public class MyTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL myurl=new URL(strings[0]);
                HttpURLConnection con= (HttpURLConnection) myurl.openConnection();
                InputStream is=con.getInputStream();
                InputStreamReader ir=new InputStreamReader(is);
                BufferedReader br=new BufferedReader(ir);
                String str=br.readLine();
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

            return "ERROR";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
           // Toast.makeText(MainActivity.this, ""+s, Toast.LENGTH_LONG).show();
            try {
                JSONObject obj=new JSONObject(s);
                JSONArray articles=obj.getJSONArray("articles");
                for(int i=0;i<articles.length();i++){
                    JSONObject obj1=articles.getJSONObject(i);
                    JSONObject source=obj1.getJSONObject("source");
                    String title=obj1.getString("title");
                    String urlToImage=obj1.getString("urlToImage");
                    String  url=obj1.getString("url");
                    String description=obj1.getString("description");
                    ListItem listItem = new ListItem(urlToImage, title,description,url);
                    arrayList.add(listItem);
                    adapter=new MyAdapter(arrayList,MainActivity.this);
                    recyclerView.setAdapter(adapter);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

    }

        }
