package com.alirabiee.datx.demo.questionnaire.service;

import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import com.alirabiee.datx.demo.questionnaire.domain.QuestionnaireRepository;
import com.alirabiee.datx.util.Is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by A on 2016-08-05.
 */
@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    QuestionnaireRepository repository;

    @Override
    public List< Questionnaire > findAll() {
        return repository.findAll();
    }

    @Override
    public Questionnaire find(final Long id) {
        return repository.findOne( id );
    }

    @Override
    public Questionnaire findThePrimary() {
        return repository.findByIsPrimary( true );
    }

    @Override
    @Transactional
    public Questionnaire save(final Questionnaire questionnaire) {
        if ( Is.yes( questionnaire.getIsPrimary() ) ) {
            final Questionnaire primary = findThePrimary();

            if ( primary != null ) {
                if ( Is.unequal( primary.getId(), questionnaire.getId() ) ) {
                    primary.setIsPrimary( false );

                    save( primary );
                }
            }
        }

        return repository.save( questionnaire );
    }

    @Override
    public void delete(final Long id) {
        repository.delete( id );
    }
}
