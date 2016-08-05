package com.alirabiee.datx.demo.answersheet.domain;

import com.alirabiee.datx.common.domain.BaseEntity;
import com.alirabiee.datx.demo.questionnaire.domain.Questionnaire;
import com.alirabiee.datx.enterprise.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by A on 2016-08-04.
 */
@Data
@Entity
@Builder( toBuilder = true )
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class AnswerSheet extends BaseEntity {
    private String comment;
    private Questionnaire questionnaire;
    private User user;

    public AnswerSheet() {
    }

    @Column( length = 500 )
    public String getComment() {
        return comment;
    }

    @ManyToOne( fetch = FetchType.LAZY )
    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    @ManyToOne( fetch = FetchType.LAZY )
    public User getUser() {
        return user;
    }
}
