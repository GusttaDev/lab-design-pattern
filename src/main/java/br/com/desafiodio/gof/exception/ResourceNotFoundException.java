package br.com.desafiodio.gof.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7218830482368601984L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id = " + id);
    }
}