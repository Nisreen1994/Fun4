package com.example.fun4demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class LoadDataBase {
    @Bean
    CommandLineRunner initDatabase(AccountRepository repository) {
        return args -> {
            log.info("Preloading" + repository.save(new Account("Nisreen", "Ajdad", false, "nisreen94@gmail.com", "123")));
            log.info("Preloading" + repository.save(new Account("Micheal", "Brouni", true, "micheal92@gmail.com", "qwe")));
        };
    }
}
