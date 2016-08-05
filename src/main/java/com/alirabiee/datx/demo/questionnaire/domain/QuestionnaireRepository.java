package com.alirabiee.datx.demo.questionnaire.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    Page< Questionnaire > findAll(Pageable pageable);

    Questionnaire findByIsPrimary(Boolean isPrimary);
}
