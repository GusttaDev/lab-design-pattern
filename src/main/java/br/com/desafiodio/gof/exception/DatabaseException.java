package br.com.desafiodio.gof.exception;

public class DatabaseException extends RuntimeException{
    private static final long serialVersionUID = -7552226056670293102L;

    public DatabaseException(String message) {
        super(message);
    }
}
