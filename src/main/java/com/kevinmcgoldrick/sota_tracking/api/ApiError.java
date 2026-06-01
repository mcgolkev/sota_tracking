package com.kevinmcgoldrick.sota_tracking.api;

import java.util.List;

public class ApiError {

    public static class FieldError {
        private String field;
        private String message;

        public FieldError() {}

        public FieldError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }

    private String type;
    private String message;
    private List<FieldError> fieldErrors;

    public ApiError(String type, String message, List<FieldError> fieldErrors) {
        this.type = type;
        this.message = message;
        this.fieldErrors = fieldErrors;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}
