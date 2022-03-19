package me.hajoo.springcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    @NotNull
    Long id;
    @Size(min = 2, max = 255)
    String name;
    @Positive(message = "나이는 1살 이상이어야 합니다.")
    Integer age;
    @Positive(message = "키는 1cm 이상이어야 합니다.")
    Integer height;
    @Positive(message = "몸무게는 1kg 이상이어야 합니다.")
    Integer weight;
}
