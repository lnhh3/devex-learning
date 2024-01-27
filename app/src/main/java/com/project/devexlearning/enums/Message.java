package com.project.devexlearning.enums;

import androidx.annotation.NonNull;

public enum Message {
    // ERROR
    NETWORK_ERROR("One-tap encountered a network error."),
    // CLOSE
    ONE_TAP_CLOSE("One-tap dialog was closed."),
    // FAILURE
    LOGIN_FAILURE("Failed to Sign In!"),
    SIGN_OUT_FAILURE("Failed to Sign Out!"),
    // SUCCESSFULLY
    SIGN_OUT_SUCCESSFULLY("Signed Out!"),
    LOGIN_SUCCESSFULLY("Login successfully!"),
    REGISTER_SUCCESSFULLY("Register successfully!"),
    // NOT MATCH
    CONFIRM_PASSWORD_NOT_MATCH("Confirm password does not match!"),
    // EXISTED
    USER_NOT_EXISTED("User does not exist!"),
    // EMPTY
    USERNAME_CANNOT_EMPTY("Username cannot be empty!"),
    EMAIL_CANNOT_EMPTY("Email cannot be empty!"),
    FULL_NAME_CANNOT_EMPTY("Full name cannot be empty!"),
    PASSWORD_CANNOT_EMPTY("Password cannot be empty!"),
    CONFIRM_PASSWORD_CANNOT_EMPTY("Confirm password cannot be empty!"),
    // INVALID
    INVALID_CREDENTIALS_2("Couldn't get credential from result."),
    INVALID_CREDENTIALS("Invalid credentials!"),
    INVALID_USERNAME("Invalid username!"),
    INVALID_PASSWORD("Invalid password!");

    private final String message;
    private Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
