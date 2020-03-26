package com.kys.example.service;

import com.kys.example.common.response.Response;
import com.kys.example.dto.PersonModifyDTO;
import com.kys.example.dto.PersonRegDTO;

/**
 * 사용자 도메인 관련 서비스
 * @author kody.kim
 * @since 29/01/2020
 */
public interface PersonService {

    /**
     * 사용자 추가
     * @param request 사용자 정보
     * @return
     */
    Response addPerson(PersonRegDTO request);

    /**
     * 사용자 정보 수정
     * @param request 변경될 사용자 정보
     * @return
     */
    Response modifyPerson(PersonModifyDTO request);

    /**
     * 이름으로 조회
     * @param name
     * @return
     */
    Response findPersonByName(String name);

}
