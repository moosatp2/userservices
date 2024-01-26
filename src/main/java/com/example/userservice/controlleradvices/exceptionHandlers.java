package com.example.userservice.controlleradvices;

import com.example.userservice.dtos.ExceptionDto;
import com.example.userservice.exceptions.userNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class exceptionHandlers {

    @ExceptionHandler(userNotFoundException.class)

    public ResponseEntity<ExceptionDto>
    handleUserNotExistException(userNotFoundException exception) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(exception.getMessage());
        dto.setDetails("Details: check user id entered with URL");

        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoResourceFoundException.class)

    public ResponseEntity<ExceptionDto> handleInvalidUrlException(NoResourceFoundException exception){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Invalid URL");
        dto.setDetails("Details : please check the URL path");

        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDto> handleHttpNotReadableException(HttpMessageNotReadableException exception){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Invalid JSON Body");
        dto.setDetails("Details: invalid JSON body is not readable by HTTP engine ");

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

}
