package com.kys.example.exception;

import com.kys.example.common.constants.ErrorCode;
import com.kys.example.controller.handler.GlobalRestExceptionHandler;

/**
 * 잘못된 요청 에러 관련 추상 클래스
 *
 * {@link GlobalRestExceptionHandler} 에서 httpStaths 400으로 매핑
 *
 * @author kody.kim
 * @since 23/03/2020
 */
public abstract class BadRequestException extends ApiException {

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }
}
