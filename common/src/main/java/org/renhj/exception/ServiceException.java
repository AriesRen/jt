package org.renhj.exception;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 7236104836935997927L;
    private String message;

    public ServiceException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
