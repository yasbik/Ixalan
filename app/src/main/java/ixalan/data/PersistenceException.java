package ixalan.data;

public class PersistenceException extends RuntimeException {
    public PersistenceException(final Exception cause){
        super(cause);
    }
}
