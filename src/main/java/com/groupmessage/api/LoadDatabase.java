package com.groupmessage.api;

import com.groupmessage.api.auth.interfaces.UserRepository;
import com.groupmessage.api.auth.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            // TODO - create data for these users
            log.info("Preloading " + repository.save(new User("jesse", "jesse",
                    "fowler", "jesse@fowler.com", "password")));
            log.info("Preloading " + repository.save(new User("emma", "emma",
                    "wang", "emma@wang.com", "password2")));
        };
    }
}
