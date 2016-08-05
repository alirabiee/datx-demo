package com.alirabiee.datx.demo.question.domain;

import com.alirabiee.datx.common.domain.BaseEntity;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by A on 2016-08-04.
 */
@Data
@Entity
@Builder( toBuilder = true )
@AllArgsConstructor( access = AccessLevel.PUBLIC )
@JsonInclude( JsonInclude.Include.NON_NULL )
public class Question extends BaseEntity {
    private String title;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private Questionnaire questionnaire;

    public Question() {
    }

    @Column( length = 1024 )
    public String getTitle() {
        return title;
    }

    @ManyToOne( fetch = FetchType.LAZY )
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    @Override
    public String toString() {
        return "Question{" +
               "choice4='" + choice4 + '\'' +
               ", choice3='" + choice3 + '\'' +
               ", choice2='" + choice2 + '\'' +
               ", choice1='" + choice1 + '\'' +
               ", title='" + title + '\'' +
               "} " + super.toString();
    }
}
