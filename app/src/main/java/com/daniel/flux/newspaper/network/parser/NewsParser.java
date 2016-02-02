package com.daniel.flux.newspaper.network.parser;

import com.daniel.flux.newspaper.model.News;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielnguyen on 1/13/16.
 */
public class NewsParser {
    public static final String TAG = NewsParser.class.getSimpleName();

    public List<News> parseCategories(String response) throws Exception {
        JSONObject jsonObject = new JSONObject(response);
        JSONObject homeObject = jsonObject.getJSONObject("home");
        JSONObject topicObject = homeObject.getJSONObject("TopPicks");
        JSONObject localObject = homeObject.getJSONObject("LocalNews");
        JSONObject pictureObject = homeObject.getJSONObject("Picture");
        JSONArray zoneSourceList = homeObject.getJSONArray("ZoneSourceList");

        List<News> newsList = parseListOfNews(zoneSourceList.toString());
        List<News> result = new ArrayList<>();
        result.add(parseNews(topicObject.toString()));
        result.add(parseNews(localObject.toString()));
        result.add(parseNews(pictureObject.toString()));
        result.addAll(newsList);
        return result;
    }

    public List<News> parseListOfNews(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        List<News> newsList = mapper.readValue(content, new TypeReference<List<News>>() {
        });

        return newsList;
    }

    public List<News> parseNewsListOfCategory(String content) throws Exception {
        JSONObject contentJsonObject = new JSONObject(content);
        JSONArray newsListJsonArray = contentJsonObject.getJSONArray("articlelist");
        String newsListString = newsListJsonArray.toString();
        return this.parseListOfNews(newsListString);
    }

    private News parseNews(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        News news = mapper.readValue(content, new TypeReference<News>() {
        });
        return news;
    }

    public String parseContent(String response) throws Exception {
        JSONObject object = new JSONObject(response);
        JSONObject articleObject = object.getJSONObject("article");
        String body = articleObject.getString("Body");
        return body;
    }
}