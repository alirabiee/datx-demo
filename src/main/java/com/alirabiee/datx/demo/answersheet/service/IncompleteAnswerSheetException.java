package com.alirabiee.datx.demo.answersheet.service;

import com.alirabiee.datx.common.exception.ValidationException;

/**
 * Created by A on 2016-08-05.
 */
public class IncompleteAnswerSheetException extends ValidationException {
    public IncompleteAnswerSheetException() {
        super();
    }

    public IncompleteAnswerSheetException(final String message) {
        super( message );
    }
}
