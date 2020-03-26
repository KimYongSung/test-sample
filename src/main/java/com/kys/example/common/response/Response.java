package com.kys.example.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kys.example.common.constants.ErrorCode;
import com.kys.example.exception.ApiException;
import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.util.Objects;

/**
 * @author kody.kim
 * @since 20/01/2020
 */
@Getter
public class Response {

    private final String code;

    private final String message;

    protected Response(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    private Response(String validMsg) {
        this.code = ErrorCode.CD_0001.getCode();
        this.message = validMsg;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return isEquals(ErrorCode.CD_0000);
    }

    public boolean isEquals(ErrorCode errorCode){

        if(Objects.isNull(errorCode)){
            return false;
        }

        return code.equals(errorCode.getCode()) && message.equals(errorCode.getMessage());
    }

    /**
     * API 실패 응답 생성
     * @param errorCode 결과코드
     * @return
     */
    public static Response error(ErrorCode errorCode){
        return new Response(errorCode);
    }

    /**
     * API 실패 응답 생성
     * @param ex 결과코드
     * @return
     */
    public static Response error(ApiException ex){
        return new Response(ex.getErrorCode());
    }

    /**
     * 시스템 에러 생성
     * @return
     */
    public static Response systemError() {
        return new Response(ErrorCode.CD_S999);
    }

    /**
     * 파라미터 유효성 실패 에러
     *
     * @param result
     * @return
     */
    public static Response error(BindingResult result) {
        return Objects.isNull(result) ? new Response(ErrorCode.CD_0001) : new Response(result.getFieldError().getDefaultMessage());
    }
    /**
     * API 성공 응답 생성
     * @return
     */
    public static Response ok(){
        return new Response(ErrorCode.CD_0000);
    }
}
