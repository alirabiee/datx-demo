package com.alirabiee.datx.demo.answersheet.domain;

import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import com.alirabiee.datx.enterprise.user.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class represents the repository for answer sheets.
 *
 * Created by A on 2016-08-05.
 */
@Repository
public interface AnswerSheetRepository extends CrudRepository< AnswerSheet, Long > {
    List< AnswerSheet > findByQuestionnaire(Questionnaire questionnaire);
    List< AnswerSheet > findByQuestionnaireAndUser(Questionnaire questionnaire, User user);
}
