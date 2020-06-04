package com.backend.template.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StoryNotBelongUserException extends RuntimeException {

    public StoryNotBelongUserException(String message) {
        super(message);
    }
}