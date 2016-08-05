package com.alirabiee.datx.demo.question.service;

import com.alirabiee.datx.common.exception.ValidationException;
import com.alirabiee.datx.demo.question.domain.Question;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;

import java.util.List;

/**
 * Created by A on 2016-08-05.
 */
public interface QuestionService {
    List< Question > findByQuestionnaire(Questionnaire questionnaire);

    Question find(Long id);

    Question save(Question question) throws ValidationException;

    void delete(Long id);
}
