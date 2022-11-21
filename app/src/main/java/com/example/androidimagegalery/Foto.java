package com.example.androidimagegalery;

public class Foto {
    private int id;
    private int width;
    private int height;
    private String url;
    private String alt;
    private String original;

    public Foto(int id, int width, int height, String url, String alt, String original) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.url = url;
        this.alt = alt;
        this.original = original;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }
}
