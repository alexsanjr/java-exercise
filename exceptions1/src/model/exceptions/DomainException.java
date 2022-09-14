package model.exceptions;

import java.io.Serial;

public class DomainException extends RuntimeException {
    public DomainException(String msg) {
        super(msg);
    }
}
