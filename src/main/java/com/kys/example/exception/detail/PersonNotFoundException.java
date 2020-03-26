package com.kys.example.exception.detail;

import com.kys.example.common.constants.ErrorCode;
import com.kys.example.exception.DataNotFoundException;

/**
 * @author kody.kim
 * @since 23/03/2020
 */
public class PersonNotFoundException extends DataNotFoundException {

    public PersonNotFoundException() {
        super(ErrorCode.CD_1001);
    }
}
