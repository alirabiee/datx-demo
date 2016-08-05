package com.alirabiee.datx.enterprise.user.domain;

import com.alirabiee.datx.common.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by A on 2016-08-04.
 */
@Data
@Entity
public class User extends BaseEntity {
    private String username;
    private String password;
}
