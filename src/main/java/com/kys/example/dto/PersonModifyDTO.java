package com.kys.example.dto;

import com.kys.example.model.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonModifyDTO {

    @NotNull(message = "id 는 필수 입니다.")
    @Min(value = 1, message = "id는 0보다 커야 합니다.")
    private Long id;

    @Size(max = 255, message = "address가 255 자릿수를 초과하였습니다.")
    private String address;

    @Min(value = 1, message = "age 0보다 커야 합니다.")
    private Integer age;

    public final Person toEntity(){
        return Person.builder()
                .id(this.id)
                .address(this.address)
                .age(this.age)
                .build();
    }
}
