package com.alirabiee.datx.demo.question.service;

import com.alirabiee.datx.demo.question.domain.Question;
import com.alirabiee.datx.demo.question.domain.QuestionRepository;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
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
    public Question find(final Long id) {
        return repository.findOne( id );
    }

    @Override
    public Question save(final Question question) {
        return repository.save( question );
    }

    @Override
    public void delete(final Long id) {
        repository.delete( id );
    }
}
