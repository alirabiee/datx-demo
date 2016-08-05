package com.alirabiee.datx.demo.answersheet.service;

import com.alirabiee.datx.common.exception.ValidationException;
import com.alirabiee.datx.demo.answer.domain.Answer;
import com.alirabiee.datx.demo.answer.service.AnswerService;
import com.alirabiee.datx.demo.answersheet.domain.AnswerSheet;
import com.alirabiee.datx.demo.answersheet.domain.AnswerSheetRepository;
import com.alirabiee.datx.demo.question.domain.Question;
import com.alirabiee.datx.demo.question.service.QuestionService;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import com.alirabiee.datx.enterprise.user.domain.User;
import com.alirabiee.datx.enterprise.user.service.UserService;
import com.alirabiee.datx.util.Is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by A on 2016-08-05.
 */
@Service
public class AnswerSheetServiceImpl implements AnswerSheetService {
    @Autowired
    AnswerSheetRepository repository;
    @Autowired
    AnswerService answerService;
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;

    @Override
    public List< AnswerSheet > findByQuestionnaire(final Questionnaire questionnaire) {
        return repository.findByQuestionnaire( questionnaire );
    }

    @Override
    public List< AnswerSheet > findByQuestionnaireAndUser(final Questionnaire questionnaire, final User user) {
        return repository.findByQuestionnaireAndUser( questionnaire, user );
    }

    @Override
    public AnswerSheet find(final Long id) {
        return repository.findOne( id );
    }

    @Override
    @Transactional( rollbackOn = ValidationException.class )
    public AnswerSheet save(final AnswerSheet answerSheet, final List< Answer > answers) throws ValidationException {
        final User currentUser = userService.getCurrentUser();

        answerSheet.setUser( currentUser );

        validateAnswerSheet( answerSheet, answers, currentUser );

        final AnswerSheet savedSheet = repository.save( answerSheet );

        for ( Answer answer : answers ) {
            answer.setAnswerSheet( savedSheet );

            answerService.save( answer );
        }

        return savedSheet;
    }

    private void validateAnswerSheet(final AnswerSheet answerSheet, final List< Answer > answers,
                                     final User currentUser) throws ValidationException {
        final Questionnaire questionnaire = answerSheet.getQuestionnaire();

        if ( questionnaire == null ) {
            throw new UndefinedQuestionnaireException();
        }

        final List< AnswerSheet > sheets = repository.findByQuestionnaireAndUser( questionnaire, currentUser );

        if ( !Is.empty( sheets ) ) {
            throw new AnswerSheetAlreadyExistsException(
                String.format( "Answer sheet already exists for %s.", currentUser.toString() )
            );
        }

        final List< Question > questions = questionService.findByQuestionnaire( questionnaire );

        if ( answers == null || questions.size() != answers.size() ) {
            throw new IncompleteAnswerSheetException(
                String.format( "There are %d questions that must be answered.", questions.size() )
            );
        }
    }

    @Override
    public void delete(final Long id) {
        repository.delete( id );
    }
}
