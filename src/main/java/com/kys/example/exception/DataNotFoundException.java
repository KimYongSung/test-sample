package com.kys.example.exception;

import com.kys.example.common.constants.ErrorCode;
import com.kys.example.controller.handler.GlobalRestExceptionHandler;

/**
 * 데이터 결과가 없는 에러 관련 추상 클래스
 *
 * {@link GlobalRestExceptionHandler} 에서 httpStaths 404로 매핑
 *
 * @author kody.kim
 * @since 23/03/2020
 */
public abstract class DataNotFoundException extends ApiException{

    public DataNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

}
