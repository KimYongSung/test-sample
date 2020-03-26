package com.kys.example.dto;

import com.kys.example.model.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonRegDTO{

    @NotEmpty(message = "name 은 필수 입니다.")
    private String name;

    @NotEmpty(message = "address 는 필수 입니다.")
    private String address;

    @NotNull(message = "age 는 필수 값 입니다.")
    @Min(value = 1, message = "age 는 0보다 커야 합니다.")
    private Integer age;

    public Person toEntity(){
        return Person.builder()
                     .address(this.address)
                     .age(this.age)
                     .name(this.name)
                     .build();
    }
}
