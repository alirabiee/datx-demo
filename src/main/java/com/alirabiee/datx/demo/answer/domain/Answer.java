package com.alirabiee.datx.demo.answer.domain;

import com.alirabiee.datx.common.domain.BaseEntity;
import com.alirabiee.datx.demo.answersheet.domain.AnswerSheet;
import com.alirabiee.datx.demo.question.domain.Question;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 * Created by A on 2016-08-04.
 */
@Data
@Entity
public class Answer extends BaseEntity {
    private Integer choiceIndex;
    private Question question;
    private AnswerSheet answerSheet;

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    public Question getQuestion() {
        return question;
    }

    @ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    public AnswerSheet getAnswerSheet() {
        return answerSheet;
    }
}
