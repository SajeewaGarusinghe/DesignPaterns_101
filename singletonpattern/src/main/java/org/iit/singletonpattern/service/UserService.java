package org.iit.singletonpattern.service;

import org.iit.singletonpattern.util.AppLogger;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final AppLogger logger;

    public UserService(AppLogger logger) {
        this.logger = logger;
    }

    public void createUser(String username) {
        logger.info("User created: " + username);
    }
}