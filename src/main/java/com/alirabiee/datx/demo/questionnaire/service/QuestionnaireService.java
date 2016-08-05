package com.alirabiee.datx.demo.questionnaire.service;

import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by A on 2016-08-05.
 */
public interface QuestionnaireService {
    List< Questionnaire > findAll();

    Page< Questionnaire > findAll(Pageable pageable);

    Questionnaire find(Long id);

    Questionnaire findThePrimary();

    Questionnaire save(Questionnaire questionnaire);

    void delete(Long id);
}
