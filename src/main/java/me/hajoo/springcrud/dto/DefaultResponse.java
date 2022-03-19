package me.hajoo.springcrud.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DefaultResponse {

    private final String status;
    private final String message;
}
