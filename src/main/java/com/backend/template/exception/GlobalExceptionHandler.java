package com.backend.template.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.backend.template.constant.ResponseStatusCode;
import com.backend.template.model.response.GeneralResponse;
import com.backend.template.model.response.ResponseStatus;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleAllExceptions(Exception ex) {
        logger.error("Exception: ", ex);
        return this.createResponse(ResponseStatusCode.INTERNAL_GENERAL_SERVER_ERROR);
    }

    @ExceptionHandler({BusinessException.class})
    public final ResponseEntity<?> handleValidationExceptions(RuntimeException ex) {
        return this.createResponse(ResponseStatusCode.BUSINESS_ERROR);
    }

    private ResponseEntity<?> createResponse(ResponseStatusCode response) {
        ResponseStatus responseStatus = new ResponseStatus(response.getHttpCode().toString(), true);
        GeneralResponse<Object> responseObject = new GeneralResponse<>();
        responseObject.setStatus(responseStatus);
        return new ResponseEntity<>(responseObject, response.getHttpCode());
    }

}
