package me.hajoo.springcrud.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@RequiredArgsConstructor
public class UpdateUserRequest {

    @NotNull
    private final Long id;
    @Size(min = 2, max = 255)
    private final String name;
    @Positive(message = "나이는 1살 이상이어야 합니다.")
    private final Integer age;
    @Positive(message = "키는 1cm 이상이어야 합니다.")
    private final Integer height;
    @Positive(message = "몸무게는 1kg 이상이어야 합니다.")
    private final Integer weight;
}
