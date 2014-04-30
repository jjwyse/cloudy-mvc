package com.jjw.cloudymvc.web;

import org.springframework.http.HttpStatus;

/**
 * TODO - JJW
 *
 * @author jjwyse
 * @version %I%, %G%
 */
public class ServiceException extends RuntimeException {
    /**
     * The generated unique serial ID for the class.
     */
    private static final long serialVersionUID = -8669857713685592589L;

    HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    private String errorMessage = null;

    /**
     * A constructor with the error message.
     *
     * @param message The error message
     */
    public ServiceException(String message) { super(message); }

    /**
     * A constructor with the cause of the error.
     *
     * @param cause The cause of the error.
     */
    public ServiceException(Throwable cause) { super(cause); }

    /**
     * A constructor with the error message and the cause of the error.
     *
     * @param message The error message
     * @param cause The cause of the error.
     */
    public ServiceException(String message, Throwable cause) { super(message, cause); }

    /**
     * A constructor that takes in an {@link org.springframework.http.HttpStatus} object and the error message that will
     * get returned to the client
     *
     * @param httpStatus The HttpStatus, representing the error code that will get returned to the user
     * @param errorMessage The error message that will get returned to the user
     */
    public ServiceException(HttpStatus httpStatus, String errorMessage) {
        super(errorMessage);

        setHttpStatus(httpStatus);
        setErrorMessage(errorMessage);
    }

    public String getErrorMessage() { return errorMessage; }

    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }

    public HttpStatus getHttpStatus() { return httpStatus; }

    public void setHttpStatus(HttpStatus httpStatus) { this.httpStatus = httpStatus; }
}
