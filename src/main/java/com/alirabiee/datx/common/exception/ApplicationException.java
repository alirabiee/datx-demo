package com.alirabiee.datx.common.exception;

/**
 * Created by A on 2016-08-05.
 */
public abstract class ApplicationException extends Exception {
    public ApplicationException() {
        super();
    }

    public ApplicationException(final String message) {
        super( message );
    }

    public ApplicationException(final String message, final Throwable cause) {
        super( message, cause );
    }

    public ApplicationException(final Throwable cause) {
        super( cause );
    }

    protected ApplicationException(final String message, final Throwable cause, final boolean enableSuppression,
                                   final boolean writableStackTrace) {
        super( message, cause, enableSuppression, writableStackTrace );
    }
}
