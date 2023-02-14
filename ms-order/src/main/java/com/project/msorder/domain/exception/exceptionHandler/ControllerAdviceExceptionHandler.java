package com.project.msorder.domain.exception.exceptionHandler;

import com.project.msorder.domain.exception.CustomerNotFoundException;
import com.project.msorder.domain.exception.ErrorResponse;
import com.project.msorder.domain.exception.OrderNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdviceExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleCustomerNotFoundException(CustomerNotFoundException exception){
        ErrorResponse errorResponse = getErrorResponse(exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorResponse>handleOrderNotFoundException(OrderNotFoundException exception){
        ErrorResponse errorResponse = getErrorResponse(exception);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    private static ErrorResponse getErrorResponse(RuntimeException exception) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
        return errorResponse;
    }
}
