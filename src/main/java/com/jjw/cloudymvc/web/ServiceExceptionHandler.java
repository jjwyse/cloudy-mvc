package com.jjw.cloudymvc.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    protected ResponseEntity<Object> handleConflict(ServiceException serviceException, WebRequest request) {
        Map<String, Object> responseBody = new HashMap<String, Object>();
        responseBody.put("message", serviceException.getErrorMessage());

        return handleExceptionInternal(serviceException, responseBody, new HttpHeaders(),
                serviceException.getHttpStatus(), request);
    }
}
