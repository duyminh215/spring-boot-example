package com.backend.template.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * template
 *
 * @author longtcs
 * @created_at 04/06/2020 - 11:36
 * @created_by longtcs
 * @since 04/06/2020
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DuplicateException extends RuntimeException {
    public DuplicateException(String exception){
        super(exception);
    }
}
