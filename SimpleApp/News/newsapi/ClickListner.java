package com.example.abhishekkumar.newsapi;

import android.view.View;

/**
 * Created by Abhishek Kumar on 12/31/2018.
 */

public interface ClickListner {
    public void onClick(View view, int position);
    public void onLongClick(View view,int position);
}
