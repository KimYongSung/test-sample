package com.kys.example.common.constants;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author kody.kim
 * @since 20/01/2020
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@RequiredArgsConstructor
@Getter
@ToString
public enum ErrorCode implements Code{

    CD_0000("0000","success")
    ,CD_0001("0001","파라미터 유효성 검사 실패")
    ,CD_1001("1001", "등록된 사용자가 압닙니다.")
    ,CD_1002("1002", "이미 등록된 사용자 입니다.")
    ,CD_S999("S999","시스템 에러")
    ;

    private final String code;

    private final String message;
}
