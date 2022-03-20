package me.hajoo.springcrud.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.*;

@Getter
@RequiredArgsConstructor
public class CreateUserRequest {

    @Schema(required = true, defaultValue = "홍길동", description = "이름")
    @NotBlank
    @Size(min = 2, max = 255)
    private final String name;

    @Schema(required = true, defaultValue = "27", minimum = "1", description = "나이")
    @NotNull
    @Positive(message = "나이는 1살 이상이어야 합니다.")
    private final Integer age;

    @Schema(required = true, defaultValue = "184", minimum = "1", description = "키")
    @NotNull
    @Positive(message = "키는 1cm 이상이어야 합니다.")
    private final Integer height;

    @Schema(required = true, defaultValue = "75", minimum = "1", description = "몸무게")
    @NotNull
    @PositiveOrZero(message = "몸무게는 1kg 이상이어야 합니다.")
    private final Integer weight;
}