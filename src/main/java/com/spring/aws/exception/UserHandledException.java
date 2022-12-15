package com.spring.aws.exception;

public class UserHandledException extends RuntimeException {

    private static final long serialVersionUID = -259597483991321857L;
    private String statusMessages;
    private int httpStatus;

    public UserHandledException() {

    }

    public UserHandledException(String statusMessages, int httpStatus) {
        super();
        this.statusMessages = statusMessages;
        this.httpStatus = httpStatus;
    }

    public String getErrorMessages() {
        return statusMessages;
    }

    public void setErrorMessages(String statusMessages) {
        this.statusMessages = statusMessages;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "UserHandledException [statusMessages=" + statusMessages + ", httpStatus=" + httpStatus + "]";
    }
}
