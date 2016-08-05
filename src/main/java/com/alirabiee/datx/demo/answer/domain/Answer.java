package com.alirabiee.datx.demo.answer.domain;

import com.alirabiee.datx.common.domain.BaseEntity;
import com.alirabiee.datx.demo.answersheet.domain.AnswerSheet;
import com.alirabiee.datx.demo.question.domain.Question;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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
public class Answer extends BaseEntity {
    private Integer choiceIndex;
    private Question question;
    private AnswerSheet answerSheet;

    public Answer() {
    }

    @ManyToOne( fetch = FetchType.LAZY )
    public Question getQuestion() {
        return question;
    }

    @ManyToOne( fetch = FetchType.LAZY )
    public AnswerSheet getAnswerSheet() {
        return answerSheet;
    }
}
