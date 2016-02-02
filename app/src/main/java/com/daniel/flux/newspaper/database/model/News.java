package com.daniel.flux.newspaper.database.model;

import android.text.TextUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.j256.ormlite.field.DatabaseField;

import java.io.Serializable;

public class News implements Serializable {
    private static final String TAG = News.class.getSimpleName();

    public static class Fields {
        public static final String ID = "id";
        public static final String CONTENT = "content";
        public static final String CONTENT_ID = "content_id";
        public static final String TITLE = "title";
        public static final String PORTRAIT_AVATAR = "portrait_avatar";
        public static final String LANDSCAPE_AVATAR = "landscape_avatar";
        public static final String LIST_ID = "list_id";
        public static final String LIST_NAME = "list_name";
        public static final String LIST_TYPE = "zone";
    }

    @DatabaseField(allowGeneratedIdInsert = true, canBeNull = false, columnName = Fields.ID,
        generatedId = true)
    private long id;

    @DatabaseField(columnName = Fields.CONTENT_ID)
    private long contentId;

    @DatabaseField(columnName = Fields.TITLE)
    private String title;

    @DatabaseField(columnName = Fields.PORTRAIT_AVATAR)
    private String portraitAvatar;

    @DatabaseField(columnName = Fields.LANDSCAPE_AVATAR)
    private String landscapeAvatar;

    @DatabaseField(columnName = Fields.LIST_ID)
    private int listId;

    @DatabaseField(columnName = Fields.LIST_NAME)
    private String listName;

    @DatabaseField(columnName = Fields.LIST_TYPE)
    private String listType;

    @DatabaseField(columnName = Fields.CONTENT)
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty("ContentID")
    public long getContentId() {
        return this.contentId;
    }

    @JsonProperty("ContentID")
    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return this.title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("PortraitAvatar")
    public String getPortraitAvatar() {
        return this.portraitAvatar;
    }

    @JsonProperty("PortraitAvatar")
    public void setPortraitAvatar(String portraitAvatar) {
        this.portraitAvatar = portraitAvatar;
    }

    @JsonProperty("LandscapeAvatar")
    public String getLandscapeAvatar() {
        return this.landscapeAvatar;
    }

    @JsonProperty("LandscapeAvatar")
    public void setLandscapeAvatar(String landscapeAvatar) {
        this.landscapeAvatar = landscapeAvatar;
    }

    @JsonProperty("ListId")
    public int getListId() {
        return this.listId;
    }

    @JsonProperty("ListId")
    public void setListId(int listId) {
        this.listId = listId;
    }

    @JsonProperty("ListName")
    public String getListName() {
        return this.listName;
    }

    @JsonProperty("ListName")
    public void setListName(String listName) {
        this.listName = listName;
    }

    @JsonProperty("ListType")
    public String getListType() {
        return this.listType;
    }

    @JsonProperty("ListType")
    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        if (!TextUtils.isEmpty(this.landscapeAvatar)) {
            return this.landscapeAvatar;
        }
        return this.portraitAvatar;
    }

    public boolean isValid() {
        if (!TextUtils.isEmpty(this.content)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "News{" +
            "id=" + id +
            ", contentId=" + contentId +
            ", title='" + title + '\'' +
            ", portraitAvatar='" + portraitAvatar + '\'' +
            ", landscapeAvatar='" + landscapeAvatar + '\'' +
            ", listId=" + listId +
            ", listName='" + listName + '\'' +
            ", listType='" + listType + '\'' +
            ", content='" + content + '\'' +
            '}';
    }
}
