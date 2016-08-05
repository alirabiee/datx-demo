package com.alirabiee.datx.common.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by A on 2016-08-04.
 */
@Data
@MappedSuperclass
public abstract class BaseEntity {
    protected Long id;
    protected Boolean enabled = false;
    protected String description;

    public BaseEntity() {
    }

    public BaseEntity(final Long id) {
        this.id = id;
    }

    public BaseEntity(final Long id, final Boolean enabled, final String description) {
        this.id = id;
        this.enabled = enabled;
        this.description = description;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    @Column( length = 102400 )
    public String getDescription() {
        return description;
    }
}
