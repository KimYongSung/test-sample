package com.kys.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author kody.kim
 * @since 20/01/2020
 */
@NoArgsConstructor
@Getter
@Setter
public class Person {

    private Long id;

    private String name;

    private String address;

    private Integer age;

    @Builder
    public Person(Long id, String name, String address, Integer age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }
}
