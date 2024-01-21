package com.example.studentmanagementsystem.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timestamp;

    //Message
    private String message;

    //Details
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
