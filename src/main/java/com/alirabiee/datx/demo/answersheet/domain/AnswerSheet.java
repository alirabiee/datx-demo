package com.alirabiee.datx.demo.answersheet.domain;

import com.alirabiee.datx.common.domain.BaseEntity;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import com.alirabiee.datx.enterprise.user.domain.User;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by A on 2016-08-04.
 */
@Data
@Entity
public class AnswerSheet extends BaseEntity {
    private String comment;
    private Questionnaire questionnaire;
    private User user;

    @Column( length = 500 )
    public String getComment() {
        return comment;
    }

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    public User getUser() {
        return user;
    }
}
