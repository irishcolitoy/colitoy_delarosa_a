package com.ws101.colitoy_delarosa_a.EcommerceApi.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(EntityNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException ex) {
                ErrorResponse error = new ErrorResponse(
                                LocalDateTime.now(),
                                HttpStatus.NOT_FOUND.value(),
                                "Not Found",
                                ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(DataIntegrityViolationException.class)
        public ResponseEntity<ErrorResponse> handleDataIntegrity(DataIntegrityViolationException ex) {
                ErrorResponse error = new ErrorResponse(
                                LocalDateTime.now(),
                                HttpStatus.BAD_REQUEST.value(),
                                "Bad Request",
                                "Invalid or incomplete data: " + ex.getMostSpecificCause().getMessage());
                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<ErrorResponse> handleRuntimeError(RuntimeException ex) {
                ErrorResponse error = new ErrorResponse(
                                LocalDateTime.now(),
                                HttpStatus.NOT_FOUND.value(),
                                "Resource Error",
                                ex.getMessage());
                return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorResponse> handleValidationErrors(
                        MethodArgumentNotValidException ex) {

                String errorMessage = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                                .findFirst()
                                .orElse("Validation failed");

                ErrorResponse error = new ErrorResponse(
                                LocalDateTime.now(),
                                HttpStatus.BAD_REQUEST.value(),
                                "Validation Error",
                                errorMessage);

                return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
}