package com.project.devexlearning.entity;

public class User {
    private String uuid;
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String imgPath;

    public User() {}

    public User(String uuid, String username, String password, String email, String fullName, String imgPath) {
        this.setUuid(uuid);
        this.setUsername(username);
        this.setPassword(password);
        this.setEmail(email);
        this.setFullName(fullName);
        this.setImgPath(imgPath);
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
