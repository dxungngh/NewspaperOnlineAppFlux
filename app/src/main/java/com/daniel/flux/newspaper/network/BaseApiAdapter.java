package com.daniel.flux.newspaper.network;

import android.content.Context;

import com.daniel.flux.newspaper.config.NetworkConfig;
import com.daniel.flux.newspaper.network.parser.NewsParser;
import com.daniel.flux.newspaper.network.volley.MyVolley;

/**
 * Created by danielnguyen on 1/13/16.
 */
public class BaseApiAdapter {
    protected MyVolley volley;

    protected NewsParser newsParser;

    public BaseApiAdapter(Context context) {
        this.volley = new MyVolley(context);
        this.newsParser = new NewsParser();
    }

    public String getUrl(String link) {
        String url = NetworkConfig.HOST + link;
        return url;
    }
}
