package com.payment.app.exception;

import com.payment.app.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidPaymentException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidPayment(InvalidPaymentException ex) {

        ErrorResponseDTO error = new ErrorResponseDTO("INVALID_PAYMENT", ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
