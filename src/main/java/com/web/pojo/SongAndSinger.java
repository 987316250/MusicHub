package com.web.pojo;

import java.util.Date;

public class SongAndSinger {
    private Integer id;

    private String name;

    private Singer singer;

    private String location;

    private Date uploadtime;

   private Category category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Singer getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = singer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "SongAndSinger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singer=" + singer +
                ", location='" + location + '\'' +
                ", uploadtime=" + uploadtime +
                ", category=" + category +
                '}';
    }
}

