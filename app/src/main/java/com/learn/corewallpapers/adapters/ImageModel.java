package com.learn.corewallpapers.adapters;

public class ImageModel {
    int tempimage;
    String url;
    String name;
    String info;
    public ImageModel(int tempimage , String name){
        this.name = name;
        this.tempimage = tempimage;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTempimage() {
        return tempimage;
    }

    public void setTempimage(int tempimage) {
        this.tempimage = tempimage;
    }
}
