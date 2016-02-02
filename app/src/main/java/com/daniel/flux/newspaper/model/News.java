package com.daniel.flux.newspaper.model;

import android.text.TextUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class News implements Serializable {
    private static final String TAG = News.class.getSimpleName();

    private long id;
    private long contentId;
    private long sourceId;
    private String sourceName;
    private long zoneId;
    private String zoneName;
    private String baomoiUrl;
    private String contentUrl;
    private String title;
    private String description;
    private String shortBody;
    private int hasImage;
    private String portraitAvatar;
    private int portraitAvatarWidth;
    private int portraitAvatarHeight;
    private String landscapeAvatar;
    private int landscapeAvatarWidth;
    private int landscapeAvatarHeight;
    private String images;
    private int listId;
    private String listName;
    private String listType;
    private long date;
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

    @JsonProperty("SourceID")
    public long getSourceId() {
        return this.sourceId;
    }

    @JsonProperty("SourceID")
    public void setSourceId(long sourceId) {
        this.sourceId = sourceId;
    }

    @JsonProperty("SourceName")
    public String getSourceName() {
        return this.sourceName;
    }

    @JsonProperty("SourceName")
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @JsonProperty("ZoneID")
    public long getZoneId() {
        return this.zoneId;
    }

    @JsonProperty("ZoneID")
    public void setZoneId(long zoneId) {
        this.zoneId = zoneId;
    }

    @JsonProperty("ZoneName")
    public String getZoneName() {
        return this.zoneName;
    }

    @JsonProperty("ZoneName")
    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    @JsonProperty("baomoiUrl")
    public String getBaomoiUrl() {
        return this.baomoiUrl;
    }

    @JsonProperty("BaomoiUrl")
    public void setBaomoiUrl(String baomoiUrl) {
        this.baomoiUrl = baomoiUrl;
    }

    @JsonProperty("ContentUrl")
    public String getContentUrl() {
        return this.contentUrl;
    }

    @JsonProperty("ContentUrl")
    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    @JsonProperty("Title")
    public String getTitle() {
        return this.title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("Description")
    public String getDescription() {
        return this.description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("ShortBody")
    public String getShortBody() {
        return this.shortBody;
    }

    @JsonProperty("ShortBody")
    public void setShortBody(String shortBody) {
        this.shortBody = shortBody;
    }

    @JsonProperty("HasImage")
    public int getHasImage() {
        return this.hasImage;
    }

    @JsonProperty("HasImage")
    public void setHasImage(int hasImage) {
        this.hasImage = hasImage;
    }

    @JsonProperty("PortraitAvatar")
    public String getPortraitAvatar() {
        return this.portraitAvatar;
    }

    @JsonProperty("PortraitAvatar")
    public void setPortraitAvatar(String portraitAvatar) {
        this.portraitAvatar = portraitAvatar;
    }

    @JsonProperty("PortraitAvatarWidth")
    public int getPortraitAvatarWidth() {
        return this.portraitAvatarWidth;
    }

    @JsonProperty("PortraitAvatarWidth")
    public void setPortraitAvatarWidth(int portraitAvatarWidth) {
        this.portraitAvatarWidth = portraitAvatarWidth;
    }

    @JsonProperty("PortraitAvatarHeight")
    public int getPortraitAvatarHeight() {
        return portraitAvatarHeight;
    }

    @JsonProperty("PortraitAvatarHeight")
    public void setPortraitAvatarHeight(int portraitAvatarHeight) {
        this.portraitAvatarHeight = portraitAvatarHeight;
    }

    @JsonProperty("LandscapeAvatar")
    public String getLandscapeAvatar() {
        return this.landscapeAvatar;
    }

    @JsonProperty("LandscapeAvatar")
    public void setLandscapeAvatar(String landscapeAvatar) {
        this.landscapeAvatar = landscapeAvatar;
    }

    @JsonProperty("LandscapeAvatarWidth")
    public int getLandscapeAvatarWidth() {
        return this.landscapeAvatarWidth;
    }

    @JsonProperty("LandscapeAvatarWidth")
    public void setLandscapeAvatarWidth(int landscapeAvatarWidth) {
        this.landscapeAvatarWidth = landscapeAvatarWidth;
    }

    @JsonProperty("LandscapeAvatarHeight")
    public int getLandscapeAvatarHeight() {
        return this.landscapeAvatarHeight;
    }

    @JsonProperty("LandscapeAvatarHeight")
    public void setLandscapeAvatarHeight(int landscapeAvatarHeight) {
        this.landscapeAvatarHeight = landscapeAvatarHeight;
    }

    @JsonProperty("Images")
    public String getImages() {
        return this.images;
    }

    @JsonProperty("Images")
    public void setImages(String images) {
        this.images = images;
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

    @JsonProperty("Date")
    public long getDate() {
        return this.date;
    }

    @JsonProperty("Date")
    public void setDate(long date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "News{" +
            "id=" + id +
            ", contentId=" + contentId +
            ", sourceId=" + sourceId +
            ", sourceName='" + sourceName + '\'' +
            ", zoneId=" + zoneId +
            ", zoneName='" + zoneName + '\'' +
            ", baomoiUrl='" + baomoiUrl + '\'' +
            ", contentUrl='" + contentUrl + '\'' +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", shortBody='" + shortBody + '\'' +
            ", hasImage=" + hasImage +
            ", portraitAvatar='" + portraitAvatar + '\'' +
            ", portraitAvatarWidth=" + portraitAvatarWidth +
            ", portraitAvatarHeight=" + portraitAvatarHeight +
            ", landscapeAvatar='" + landscapeAvatar + '\'' +
            ", landscapeAvatarWidth=" + landscapeAvatarWidth +
            ", landscapeAvatarHeight=" + landscapeAvatarHeight +
            ", images='" + images + '\'' +
            ", listId=" + listId +
            ", listName='" + listName + '\'' +
            ", listType='" + listType + '\'' +
            ", date=" + date +
            '}';
    }
}
