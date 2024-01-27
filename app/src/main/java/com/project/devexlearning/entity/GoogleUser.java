package com.project.devexlearning.entity;

public class GoogleUser {
    private String uuid;
    private String displayName;
    private String profile;
    private String email;

    public GoogleUser() {}

    public GoogleUser(String uuid, String displayName, String profile, String email) {
        this.uuid = uuid;
        this.displayName = displayName;
        this.profile = profile;
        this.email = email;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
