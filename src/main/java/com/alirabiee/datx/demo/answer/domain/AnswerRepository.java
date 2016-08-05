package com.alirabiee.datx.demo.answer.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * This class represents the repository for answer sheets.
 *
 * Created by A on 2016-08-05.
 */
@Repository
public interface AnswerRepository extends CrudRepository< Answer, Long > {
    void deleteByAnswerSheetQuestionnaireId(Long questionnaireId);
}
