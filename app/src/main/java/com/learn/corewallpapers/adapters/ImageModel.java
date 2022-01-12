package com.learn.corewallpapers.adapters;

public class ImageModel {
    public String url;
    public String info;
    public String Description;
    public ImageModel(){}
    public ImageModel(String url , String info){
        this.url = url;
        this.info = info;
    }
    public String getInfo() {
        return info;
    }
    public String getUrl() {
        return url;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDescription() {
        return Description;
    }
}
