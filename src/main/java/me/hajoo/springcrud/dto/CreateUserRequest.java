package me.hajoo.springcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    @NotBlank
    @Size(min = 2, max = 255)
    String name;
    @NotNull
    @Positive(message = "나이는 1살 이상이어야 합니다.")
    Integer age;
    @NotNull
    @Positive(message = "키는 1cm 이상이어야 합니다.")
    Integer height;
    @NotNull
    @PositiveOrZero(message = "몸무게는 1kg 이상이어야 합니다.")
    Integer weight;
}