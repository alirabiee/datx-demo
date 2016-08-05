package com.alirabiee.datx.demo.question.domain;

import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class represents the repository for questions.
 *
 * Created by A on 2016-08-05.
 */
@Repository
public interface QuestionRepository extends CrudRepository< Question, Long > {
    List< Question > findByQuestionnaire(Questionnaire questionnaire);
}
