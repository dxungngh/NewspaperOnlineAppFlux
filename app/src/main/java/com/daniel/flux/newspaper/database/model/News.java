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
        public static final String SOURCE_ID = "source_id";
        public static final String SOURCE_NAME = "source_name";
        public static final String ZONE_ID = "zone_id";
        public static final String ZONE_NAME = "zone_name";
        public static final String BAO_MOI_URL = "bao_moi_url";
        public static final String CONTENT_URL = "content_url";
        public static final String TITLE = "title";
        public static final String DESCRIPTION = "description";
        public static final String SHORT_BODY = "short_body";
        public static final String HAS_IMAGE = "has_image";
        public static final String PORTRAIT_AVATAR = "portrait_avatar";
        public static final String PORTRAIT_AVATAR_WIDTH = "portrait_avatar_width";
        public static final String PORTRAIT_AVATAR_HEIGHT = "portrait_avatar_height";
        public static final String LANDSCAPE_AVATAR = "landscape_avatar";
        public static final String LANDSCAPE_AVATAR_WIDTH = "landscape_avatar_width";
        public static final String LANDSCAPE_AVATAR_HEIGHT = "landscape_avatar_height";
        public static final String IMAGES = "images";
        public static final String LIST_ID = "list_id";
        public static final String LIST_NAME = "list_name";
        public static final String LIST_TYPE = "zone";
        public static final String COMMENTS = "comments";
        public static final String DATE = "date";
    }

    @DatabaseField(allowGeneratedIdInsert = true, canBeNull = false, columnName = Fields.ID,
        generatedId = true)
    private long id;

    @DatabaseField(columnName = Fields.CONTENT_ID)
    private long contentId;

    @DatabaseField(columnName = Fields.SOURCE_ID)
    private long sourceId;

    @DatabaseField(columnName = Fields.SOURCE_NAME)
    private String sourceName;

    @DatabaseField(columnName = Fields.ZONE_ID)
    private long zoneId;

    @DatabaseField(columnName = Fields.ZONE_NAME)
    private String zoneName;

    @DatabaseField(columnName = Fields.BAO_MOI_URL)
    private String baomoiUrl;

    @DatabaseField(columnName = Fields.CONTENT_URL)
    private String contentUrl;

    @DatabaseField(columnName = Fields.TITLE)
    private String title;

    @DatabaseField(columnName = Fields.DESCRIPTION)
    private String description;

    @DatabaseField(columnName = Fields.SHORT_BODY)
    private String shortBody;

    @DatabaseField(columnName = Fields.HAS_IMAGE)
    private int hasImage;

    @DatabaseField(columnName = Fields.PORTRAIT_AVATAR)
    private String portraitAvatar;

    @DatabaseField(columnName = Fields.PORTRAIT_AVATAR_WIDTH)
    private int portraitAvatarWidth;

    @DatabaseField(columnName = Fields.PORTRAIT_AVATAR_HEIGHT)
    private int portraitAvatarHeight;

    @DatabaseField(columnName = Fields.LANDSCAPE_AVATAR)
    private String landscapeAvatar;

    @DatabaseField(columnName = Fields.LANDSCAPE_AVATAR_WIDTH)
    private int landscapeAvatarWidth;

    @DatabaseField(columnName = Fields.LANDSCAPE_AVATAR_HEIGHT)
    private int landscapeAvatarHeight;

    @DatabaseField(columnName = Fields.IMAGES)
    private String images;

    @DatabaseField(columnName = Fields.LIST_ID)
    private int listId;

    @DatabaseField(columnName = Fields.LIST_NAME)
    private String listName;

    @DatabaseField(columnName = Fields.LIST_TYPE)
    private String listType;

    @DatabaseField(columnName = Fields.DATE)
    private long date;

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
