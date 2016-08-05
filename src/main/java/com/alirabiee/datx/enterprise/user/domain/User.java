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

    public User() {
    }

    public User(final String username, final String password) {
        this.username = username;
        this.password = password;
    }

    public User(final Long id, final String username, final String password) {
        super( id );
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
               "username='" + username + '\'' +
               "} " + super.toString();
    }
}
