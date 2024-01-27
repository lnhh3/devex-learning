package com.project.devexlearning.entity;

public class Course {
    private String title;
    private double price;
    private String imgPath;

    public Course() {}

    public Course(String title, double price, String imgPath) {
        this.title = title;
        this.price = price;
        this.imgPath = imgPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
