package br.com.mayke.studyspring.exceptions;

public class BussinesException extends RuntimeException {
    public BussinesException(final String msg) {
        super(msg);
    }
}
