package com.example.userservice.controlleradvices;

import com.example.userservice.dtos.ExceptionDto;
import com.example.userservice.exceptions.userNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

}
