package com.alirabiee.datx.demo.question.domain;

import com.alirabiee.datx.common.domain.BaseEntity;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by A on 2016-08-04.
 */
@Data
@Entity
public class Question extends BaseEntity {
    private String title;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private Questionnaire questionnaire;

    @Column( length = 1024 )
    public String getTitle() {
        return title;
    }

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }
}
