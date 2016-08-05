package com.alirabiee.datx.demo.answer.service;

import com.alirabiee.datx.common.exception.ValidationException;
import com.alirabiee.datx.demo.answer.domain.Answer;

/**
 * Created by A on 2016-08-05.
 */
public interface AnswerService {
    Answer save(Answer answer) throws ValidationException;

    void deleteByAnswerSheetQuestionnaireId(Long questionnaireId);
}
