package com.example.javawebproject1.example.pojo;

public class Article {
    private Integer aid;
    private Integer kid;
    private  String title;
    private String content;
    private String time;
    private Integer type;
    private String picture;
    private String video;
    private Integer uid;
    private Integer state;
    public Article(){};
    public Article(Integer aid, String title, String time,String picture) {
        this.aid = aid;
        this.title = title;
        this.time = time;
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid=" + aid +
                ", kid=" + kid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                ", type=" + type +
                ", picture='" + picture + '\'' +
                ", video='" + video + '\'' +
                ", uid=" + uid +
                ", state=" + state +
                '}';
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
