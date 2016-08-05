package com.alirabiee.datx.enterprise.user.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * This class represents the repository for questionnaires.
 *
 * Created by A on 2016-08-05.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository< User, Long > {
    User findByUsername(String username);
}
