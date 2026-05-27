package com.ws101.colitoy_delarosa_a.EcommerceApi.model;

import java.time.LocalDateTime;

/**
 * Model class for standardized error response format.
 * Every error returned by the API will follow this structure.
 *
 * @author Your Name
 */
public class ErrorResponse {

    /** Date and time when the error occurred */
    private LocalDateTime timestamp;

    /** HTTP Status code number (e.g., 404, 500) */
    private int status;

    /** Short description of status (e.g., Not Found) */
    private String error;

    /** Detailed message explaining the error */
    private String message;

    /** API path/URL where the error happened */
    private String path;

    /**
     * Constructor to create full error response object.
     *
     * @param timestamp Time of error
     * @param status    HTTP status code
     * @param error     Status description
     * @param message   Detailed message
     * @param path      Request path
     */
    public ErrorResponse(LocalDateTime timestamp, int status, String error, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // --- Getters and Setters ---
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}