package com.alirabiee.datx.demo.questionnaire.domain;

import com.alirabiee.datx.common.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by A on 2016-08-04.
 */
@Data
@Entity
public class Questionnaire extends BaseEntity {
    private String title;
    private Boolean isPrimary;
}
