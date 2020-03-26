package com.kys.example.controller.handler;

import com.kys.example.common.constants.ErrorCode;
import com.kys.example.common.response.Response;
import com.kys.example.exception.ApiException;
import com.kys.example.exception.BadRequestException;
import com.kys.example.exception.DataNotFoundException;
import com.kys.example.exception.detail.PersonNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 예외처리 핸들러
 * @author kody.kim
 * @since 29/01/2020
 */
@RestControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handler(Exception e, WebRequest request){
        return handleExceptionInternal(e, Response.systemError(), null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<Object> handler(ApiException e, WebRequest request){
        return handleExceptionInternal(e, Response.error(e), null, HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = DataNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorCode handler(PersonNotFoundException e){
        return e.getErrorCode();
    }

    @ExceptionHandler(value = BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorCode handler(BadRequestException e){
        return e.getErrorCode();
    }

    protected ResponseEntity<Object> handleBindException(
            BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, Response.error(ex.getBindingResult()), headers, status, request);
    }
}
