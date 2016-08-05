package com.alirabiee.datx.demo.questionnaire.domain;

import com.alirabiee.datx.common.domain.BaseEntity;
import com.alirabiee.datx.demo.question.domain.Question;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * This class represents the questionnaires defined in the system.
 *
 * Created by A on 2016-08-04.
 */
@Data
@Entity
@Builder( toBuilder = true )
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class Questionnaire extends BaseEntity {
    private String title;
    private Boolean isPrimary;
    private List< Question > questions;

    public Questionnaire() {
    }

    @OneToMany( mappedBy = "questionnaire" )
    public List< Question > getQuestions() {
        return questions;
    }
}
