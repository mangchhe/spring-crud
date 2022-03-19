package me.hajoo.springcrud.exception;

import me.hajoo.springcrud.dto.DefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotValidUserIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<DefaultResponse> notValidUserIdException(final NotValidUserIdException e) {
        return ResponseEntity.badRequest().body(new DefaultResponse("U400", "유효하지 않는 유저 ID 입니다."));
    }
}
