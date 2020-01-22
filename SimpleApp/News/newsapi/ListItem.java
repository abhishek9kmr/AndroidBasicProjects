package com.example.abhishekkumar.newsapi;

import java.net.URL;
import java.util.Map;

/**
 * Created by Abhishek Kumar on 12/31/2018.
 */

public class ListItem {
    private String url;
    private String title;
    private String description;
    private String urlWeb;


    public ListItem(String url, String title, String description, String urlWeb) {
        this.url = url;
        this.title = title;
        this.description = description;
        this.urlWeb=urlWeb;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlWeb(){
        return urlWeb;
    }
}
