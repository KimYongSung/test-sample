package com.kys.example.service;

import com.kys.example.common.response.DataResponse;
import com.kys.example.common.response.Response;
import com.kys.example.dto.PersonDTO;
import com.kys.example.dto.PersonModifyDTO;
import com.kys.example.dto.PersonRegDTO;
import com.kys.example.exception.detail.AlreadyPersonException;
import com.kys.example.exception.detail.PersonNotFoundException;
import com.kys.example.model.Person;
import com.kys.example.model.mapper.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author kody.kim
 * @since 28/01/2020
 */
@RequiredArgsConstructor
@Service
public class SamplePersonService implements PersonService{

    private final PersonMapper personMapper;

    @Override
    public Response addPerson(PersonRegDTO request){

        Optional<Person> optional = personMapper.findByName(request.getName());

        if(optional.isPresent()){
            throw new AlreadyPersonException();
        }

        Person newPerson = request.toEntity();

        personMapper.insert(newPerson);

        return DataResponse.ok(newPerson.getId());
    }

    @Override
    public Response modifyPerson(PersonModifyDTO request) {

        if(personMapper.countById(request.getId()) != 1){
            throw new PersonNotFoundException();
        }

        Person person = request.toEntity();

        personMapper.update(person);

        return Response.ok();
    }

    @Override
    public Response findPersonByName(String name){

        Person person = personMapper.findByName(name)
                                    .orElseThrow(PersonNotFoundException::new);

        return DataResponse.ok(PersonDTO.of(person));
    }

}
