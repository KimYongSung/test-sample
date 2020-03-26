package com.kys.example.controller;

import com.kys.example.common.response.Response;
import com.kys.example.dto.PersonModifyDTO;
import com.kys.example.dto.PersonRegDTO;
import com.kys.example.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonService service;

    @PostMapping(value = "/person")
    public ResponseEntity<Response> addPerson(@Valid PersonRegDTO request){

        Response response = service.addPerson(request);

        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/person/{name}")
    public ResponseEntity<Response> findPersonByName(@PathVariable String name){

        Response response = service.findPersonByName(name);

        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/modify/person")
    public ResponseEntity<Response> modifyPerson(@Valid PersonModifyDTO request){

        Response response = service.modifyPerson(request);

        return ResponseEntity.ok(response);
    }
}
