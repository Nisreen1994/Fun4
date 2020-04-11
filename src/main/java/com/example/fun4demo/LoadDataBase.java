package com.example.fun4demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class LoadDataBase {
    @Bean
    CommandLineRunner initDatabase(AccountRepository repository, TimesheetRepository timesheetRepository) {
        return args -> {
            Account account1 = new Account("Nisreen", "Ajdad", false, "nisreen94@gmail.com", "123" );
            Account account2;
            Timesheet timesheet1 = new Timesheet(account1);
            long idAccount = account1.getId();


            log.info("Preloading" + repository.save(account1));
            log.info("Preloading" + repository.save(account2=new Account("Micheal", "Brouni", true, "micheal92@gmail.com", "qwe")));
            //log.info("Preloading" + timesheetRepository.save(timesheet1));
        };
    }

}
