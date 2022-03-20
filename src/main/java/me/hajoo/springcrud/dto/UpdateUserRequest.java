package me.hajoo.springcrud.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Getter
@RequiredArgsConstructor
public class UpdateUserRequest {

    @Schema(required = true, defaultValue = "1", description = "유저 ID")
    @NotNull
    private final Long id;

    @Schema(defaultValue = "홍길동2", minLength = 2, maxLength = 255, description = "이름")
    @Size(min = 2, max = 255)
    private final String name;

    @Schema(defaultValue = "25", minimum = "1", description = "나이")
    @Positive(message = "나이는 1살 이상이어야 합니다.")
    private final Integer age;

    @Schema(defaultValue = "185", minimum = "1", description = "키")
    @Positive(message = "키는 1cm 이상이어야 합니다.")
    private final Integer height;

    @Schema(defaultValue = "80", minimum = "1", description = "몸무게")
    @Positive(message = "몸무게는 1kg 이상이어야 합니다.")
    private final Integer weight;
}
