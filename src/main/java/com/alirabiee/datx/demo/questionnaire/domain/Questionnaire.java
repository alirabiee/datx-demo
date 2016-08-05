package com.alirabiee.datx.demo.questionnaire.domain;

import com.alirabiee.datx.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

/**
 * This class represents the questionnaires defined in the system.
 *
 * Created by A on 2016-08-04.
 */
@SuppressWarnings( "Lombok" )
@Data
@Entity
@Builder( toBuilder = true )
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class Questionnaire extends BaseEntity {
    private String title;
    private Boolean isPrimary;

    public Questionnaire() {
    }
}
