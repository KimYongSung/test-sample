package com.kys.example.exception;

import com.kys.example.common.constants.ErrorCode;
import lombok.Getter;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author kody.kim
 * @since 23/03/2020
 */
@Getter
@ResponseStatus
public class ApiException extends RuntimeException {

    private final ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public String getCode(){
        return errorCode.getCode();
    }
}
