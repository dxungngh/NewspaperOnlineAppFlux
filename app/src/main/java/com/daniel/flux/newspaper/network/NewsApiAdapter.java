package com.daniel.flux.newspaper.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.daniel.flux.newspaper.callback.OnFetchNewsDetailListener;
import com.daniel.flux.newspaper.callback.OnFetchNewsesListListener;
import com.daniel.flux.newspaper.model.News;
import com.daniel.flux.newspaper.network.volley.MyRequest;

import java.util.List;

/**
 * Created by danielnguyen on 1/11/16.
 */
public class NewsApiAdapter extends BaseApiAdapter {
    private static final String TAG = NewsApiAdapter.class.getSimpleName();

    public NewsApiAdapter(Context context) {
        super(context);
    }

    public void fetchCategoriesOfServer(final OnFetchNewsesListListener listener) {
        String url = getUrl("json/home.aspx?v=2&showzonesources=1&zonesources=:119[zone]:58[zone]:52[zone]:55[zone]:45[zone]:54[zone]:121[zone]:53[zone]:82[zone]:59[zone]:145[zone]:147[zone]:84[zone]:71[zone]:79[zone]:72[zone]:132[zone]:137[zone]:3[zini]:4[zini]&toppicks=1&pictures=1&articlesstart=0&articlescount=0&toppicksImageType=2&pictureImageType=0&localNews=1&adminArea=C%E1%BA%A7uGi%E1%BA%A5y&subAdminArea=H%C3%A0N%E1%BB%99i&imageMinSize=300");
        MyRequest request = new MyRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        List<News> newsList = NewsApiAdapter.this.newsParser.parseCategories(response);
                        listener.onSuccess(newsList);
                    } catch (Exception e) {
                        listener.onFailed(e);
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    listener.onFailed(error);
                }
            });
        this.volley.addToRequestQueue(request);
    }

    public void fetchNewsesListOfCategory(int start, int count, String type, int typeId, int imageMinSize, final OnFetchNewsesListListener listener) {
        String url = getUrl(String.format("json/articlelist.aspx?start=%d&count=%d&listType=%s&listId=%d&imageMinSize=%d", start, count, type, typeId, imageMinSize));
        MyRequest request = new MyRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        List<News> newsList = NewsApiAdapter.this.newsParser.parseNewsListOfCategory(response);
                        listener.onSuccess(newsList);
                    } catch (Exception e) {
                        listener.onFailed(e);
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    listener.onFailed(error);
                }
            });
        volley.addToRequestQueue(request);
    }

    public void fetchNewsDetail(long newsId, final OnFetchNewsDetailListener listener) {
        String url = getUrl(String.format("json/article.aspx?articleid=%d", newsId));
        MyRequest request = new MyRequest(Request.Method.GET, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        String content = NewsApiAdapter.this.newsParser.parseContent(response);
                        listener.onSuccess(content);
                    } catch (Exception e) {
                        listener.onFailed(e);
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    listener.onFailed(error);
                }
            });
        volley.addToRequestQueue(request);
    }
}