package com.alirabiee.datx.demo.questionnaire.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class represents the repository for questionnaires.
 *
 * Created by A on 2016-08-05.
 */
@Repository
public interface QuestionnaireRepository extends PagingAndSortingRepository< Questionnaire, Long > {
    List< Questionnaire > findAll();

    Questionnaire findByIsPrimary(Boolean isPrimary);
}
