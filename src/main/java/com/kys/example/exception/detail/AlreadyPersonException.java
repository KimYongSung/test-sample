package com.kys.example.exception.detail;

import com.kys.example.common.constants.ErrorCode;
import com.kys.example.exception.ApiException;
import com.kys.example.exception.BadRequestException;

/**
 * @author kody.kim
 * @since 23/03/2020
 */
public class AlreadyPersonException extends BadRequestException {

    public AlreadyPersonException() {
        super(ErrorCode.CD_1002);
    }
}
