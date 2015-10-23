package com.example.kevin.newsbroadcast;

/**
 * Created by Kevin on 10/7/2015.
 */
public class News {
    private String title;
    private String description;
    private String time;
    private String content_url;
    private String pic_url;

    public News(String title, String description, String time, String content_url, String pic_url){
        this.title = title;
        this.description = description;
        this.time = time;
        this.content_url = content_url;
        this.pic_url = pic_url;
    }

    public String getContent_url() {
        return content_url;
    }

    public void setContent_url(String content_url) {
        this.content_url = content_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
