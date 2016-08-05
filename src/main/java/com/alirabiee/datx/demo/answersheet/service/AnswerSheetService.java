package com.alirabiee.datx.demo.answersheet.service;

import com.alirabiee.datx.common.exception.ValidationException;
import com.alirabiee.datx.demo.answer.domain.Answer;
import com.alirabiee.datx.demo.answersheet.domain.AnswerSheet;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import com.alirabiee.datx.enterprise.user.domain.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by A on 2016-08-05.
 */
public interface AnswerSheetService {
    List< AnswerSheet > findByQuestionnaire(Questionnaire questionnaire);

    List< AnswerSheet > findByQuestionnaireAndUser(Questionnaire questionnaire, User user);

    AnswerSheet find(Long id);

    @Transactional
    AnswerSheet save(AnswerSheet answerSheet, List< Answer > answers) throws ValidationException;

    void delete(Long id);
}
