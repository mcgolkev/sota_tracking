package com.kevinmcgoldrick.sota_tracking.api;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex) {
        List<ApiError.FieldError> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> new ApiError.FieldError(fe.getField(), fe.getDefaultMessage()))
                .toList();

        ApiError body = new ApiError(
                "VALIDATION_ERROR",
                "One or more fields are invalid",
                fieldErrors
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleDataIntegrity(DataIntegrityViolationException ex) {

        String msg = ex.getMostSpecificCause() != null ? ex.getMostSpecificCause().getMessage() : "";

        if (msg.contains("null value in column \"summit_ref\"")) {
            return ResponseEntity.badRequest().body(new ApiError(
                    "VALIDATION_ERROR",
                    "One or more fields are invalid",
                    List.of(new ApiError.FieldError("summitRef", "Summit Ref is required"))
            ));
        }

        if (msg.contains("null value in column \"activation_date\"")) {
            return ResponseEntity.badRequest().body(new ApiError(
                    "VALIDATION_ERROR",
                    "One or more fields are invalid",
                    List.of(new ApiError.FieldError("activationDate", "Activation Date is required"))
            ));
        }

        if (msg.contains("null value in column \"mode\"")) {
            return ResponseEntity.badRequest().body(new ApiError(
                    "VALIDATION_ERROR",
                    "One or more fields are invalid",
                    List.of(new ApiError.FieldError("mode", "Mode is required"))
            ));
        }

        if (msg.contains("null value in column \"frequency_mhz\"")) {
            return ResponseEntity.badRequest().body(new ApiError(
                    "VALIDATION_ERROR",
                    "One or more fields are invalid",
                    List.of(new ApiError.FieldError("frequencyMhz", "Frequency is required"))
            ));
        }

        // generic error catch
        return ResponseEntity.badRequest().body(new ApiError(
                "DATA_INTEGRITY_ERROR",
                "Could not save activation due to data constraints",
                List.of()
        ));
    }

}
