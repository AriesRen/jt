package org.renhj.exception;

public class ResourceNotExistException extends RuntimeException {
    private static final long serialVersionUID = 2374851919752587257L;
    private String message;

    public ResourceNotExistException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
