package co.com.keralty.archetype.domain.exception;

public class ConsultaException extends RuntimeException {

    public ConsultaException(String message) {
        super(message);
    }

    public ConsultaException(String message, Throwable cause) {
        super(message, cause);
    }
}

