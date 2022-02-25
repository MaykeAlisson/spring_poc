package br.com.mayke.studyspring.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(final String msg) {
        super(msg);
    }
}
