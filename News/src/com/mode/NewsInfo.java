package com.mode;

public class NewsInfo {
    private int id;
    private String writer;
    private String subject;
    private String title;
    private String des;
    private String time;
    private String imgPath;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "NewsInfo{" +
                "id=" + id +
                ", writer='" + writer + '\'' +
                ", subject='" + subject + '\'' +
                ", title='" + title + '\'' +
                ", des='" + des + '\'' +
                ", time='" + time + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
