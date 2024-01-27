package com.project.devexlearning.validation;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);

    public static <T> boolean checkNotNullAndNotEmptyList(List<T> t) {
        return t != null && !t.isEmpty();
    }

    public static <T> boolean checkNullOrEmptyList(List<T> t) {
        return t == null || t.isEmpty();
    }

    public static <T> boolean checkNullOrEmptyString(T t) {
        return t == null || t.toString().trim().isEmpty();
    }

    public static <T> boolean checkNullOrNotEmptyString(T t) {
        return t == null || !t.toString().trim().isEmpty();
    }

    public static <T> boolean checkNotNullAndNotEmptyString(T t) {
        return t != null && !t.toString().trim().isEmpty();
    }

    public static <T> boolean checkNotNull(T t) {
        return t != null;
    }

    public static <T> boolean checkNull(T t) {
        return t == null;
    }

    public static <T> boolean checkEmptyString(T t) {
        return t.toString().trim().isEmpty();
    }

    public static <T> boolean checkNotEmptyString(T t) {
        return !t.toString().trim().isEmpty();
    }

    public static <T> boolean checkEmptyObject(List<T> t) {
        return t.isEmpty();
    }
}
