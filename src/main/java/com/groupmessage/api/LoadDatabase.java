package com.groupmessage.api;

import com.groupmessage.api.auth.interfaces.UserRepository;
import com.groupmessage.api.auth.models.User;
import com.groupmessage.api.controllers.interfaces.MessageRepository;
import com.groupmessage.api.controllers.models.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, MessageRepository messageRepository) {
        return args -> {
            // Create test users
            log.info("Preloading " + userRepository.save(new User("galileo", "galileo",
                    "galilei", "galileo@gmail.com", "password")));
            log.info("Preloading " + userRepository.save(new User("bob", "bob",
                    "saget", "bob@gmail.com", "password2")));
            log.info("Preloading " + userRepository.save(new User("lilo", "lilo",
                    "schnoodle", "lilo@schnoodle.com", "password3")));

            // Todo - Create test conversations

            // Todo - Create test messages
        };
    }
}
