package me.hajoo.springcrud.exception;

public class NotValidUserIdException extends IllegalArgumentException {

    public NotValidUserIdException() {}

    public NotValidUserIdException(final String s) {
        super(s);
    }
}
