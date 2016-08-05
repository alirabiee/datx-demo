package com.alirabiee.datx.demo.question.service;

import com.alirabiee.datx.common.exception.ValidationException;
import com.alirabiee.datx.demo.question.domain.Question;
import com.alirabiee.datx.demo.question.domain.QuestionRepository;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import com.alirabiee.datx.util.Is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by A on 2016-08-05.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository repository;

    @Override
    public List< Question > findByQuestionnaire(final Questionnaire questionnaire) {
        return repository.findByQuestionnaire( questionnaire );
    }

    @Override
    public Long countByQuestionnaire(final Questionnaire questionnaire) {
        return repository.countByQuestionnaire( questionnaire );
    }

    @Override
    public Question find(final Long id) {
        return repository.findOne( id );
    }

    @Override
    public Question save(final Question question) throws ValidationException {
        validateQuestion( question );

        return repository.save( question );
    }

    private void validateQuestion(final Question question) throws ValidationException {
        if ( question.getQuestionnaire() == null ) {
            throw new UndefinedQuestionnaireException();
        }

        if ( Is.empty( question.getTitle() ) ) {
            throw new UndefinedTitleException();
        }

        if ( Is.empty( question.getChoice1() )
             || Is.empty( question.getChoice2() )
             || Is.empty( question.getChoice3() )
             || Is.empty( question.getChoice4() ) ) {
            throw new AllChoicesRequiredException();
        }
    }

    @Override
    public void delete(final Long id) {
        repository.delete( id );
    }
}
