package com.alirabiee.datx.demo.questionnaire.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by A on 2016-08-05.
 */
public interface QuestionnaireRepository extends PagingAndSortingRepository< Questionnaire, Long > {
    List< Questionnaire > findAll();

    Questionnaire findByIsPrimary(Boolean isPrimary);
}
