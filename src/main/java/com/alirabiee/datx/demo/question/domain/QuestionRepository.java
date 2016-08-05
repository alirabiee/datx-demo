package com.alirabiee.datx.demo.question.domain;

import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by A on 2016-08-05.
 */
public interface QuestionRepository extends CrudRepository< Question, Long > {
    List< Question > findByQuestionnaire(Questionnaire questionnaire);
}
