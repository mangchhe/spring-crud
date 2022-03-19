package me.hajoo.springcrud.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;

@Getter
@RequiredArgsConstructor
public class CreateUserRequest {

    @NotBlank
    @Size(min = 2, max = 255)
    private final String name;
    @NotNull
    @Positive(message = "나이는 1살 이상이어야 합니다.")
    private final Integer age;
    @NotNull
    @Positive(message = "키는 1cm 이상이어야 합니다.")
    private final Integer height;
    @NotNull
    @PositiveOrZero(message = "몸무게는 1kg 이상이어야 합니다.")
    private final Integer weight;
}