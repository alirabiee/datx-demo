package com.alirabiee.datx.enterprise.user.service;

import com.alirabiee.datx.enterprise.user.domain.User;
import com.alirabiee.datx.enterprise.user.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by A on 2016-08-05.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public User getCurrentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if ( !authentication.isAuthenticated() ) {
            return null;
        }

        final org.springframework.security.core.userdetails.User principal = ( org.springframework.security.core.userdetails.User ) authentication.getPrincipal();

        return repository.findByUsername( principal.getUsername() );
    }
}
