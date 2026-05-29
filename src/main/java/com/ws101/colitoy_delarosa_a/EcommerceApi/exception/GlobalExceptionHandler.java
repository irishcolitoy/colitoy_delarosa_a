package com.ws101.colitoy_delarosa_a.EcommerceApi.exception;

import com.ws101.colitoy_delarosa_a.EcommerceApi.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;

/**
 * Global exception handler to catch and format all errors consistently.
 * Ensures all errors return same structure: timestamp, status, error, message,
 * path.
 *
 * @author Your Name
 * @see ErrorResponse
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles cases where requested resource/ID is not found.
     * Returns HTTP Status 404.
     *
     * @param ex      Exception thrown (contains message)
     * @param request Web request details to extract path
     * @return Formatted error response with NOT FOUND status
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Catch-all handler for any other unexpected errors.
     * Returns HTTP Status 500.
     *
     * @param ex      Exception thrown
     * @param request Web request details
     * @return Formatted error response with INTERNAL SERVER ERROR status
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getDescription(false).replace("uri=", ""));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}