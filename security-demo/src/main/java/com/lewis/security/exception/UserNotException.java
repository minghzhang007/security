package com.lewis.security.exception;

/**
 * Created by Administrator on 2017/9/10.
 */
public class UserNotException extends RuntimeException {

    private Integer id;
    public UserNotException(Integer id) {
        super("user not exists !");
        this.id = id;
    }

    public UserNotException(String message) {
        super(message);
    }

    public UserNotException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotException(Throwable cause) {
        super(cause);
    }

    public UserNotException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
