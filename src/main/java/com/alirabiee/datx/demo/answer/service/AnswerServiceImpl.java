package com.alirabiee.datx.demo.answer.service;

import com.alirabiee.datx.common.exception.ValidationException;
import com.alirabiee.datx.demo.answer.domain.Answer;
import com.alirabiee.datx.demo.answer.domain.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by A on 2016-08-05.
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    AnswerRepository repository;

    @Override
    public Answer save(final Answer answer) throws ValidationException {
        validateAnswer( answer );

        return repository.save( answer );
    }

    private void validateAnswer(final Answer answer) throws ValidationException {
        if ( answer.getChoiceIndex() == null ) {
            throw new UndefinedChoiceIndexException();
        }

        if ( answer.getAnswerSheet() == null ) {
            throw new UndefinedAnswerSheetException();
        }

        if ( answer.getQuestion() == null ) {
            throw new UndefinedQuestionException();
        }

        if ( answer.getChoiceIndex() < 1 || answer.getChoiceIndex() > 4 ) {
            throw new ChoiceIndexOutOfBoundException();
        }
    }
}
