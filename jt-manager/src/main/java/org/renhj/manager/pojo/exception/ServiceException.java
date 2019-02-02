package org.renhj.manager.pojo.exception;

public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 8027677114798743930L;
    private String message;
    public ServiceException(String message){
        super(message);
    }
}
