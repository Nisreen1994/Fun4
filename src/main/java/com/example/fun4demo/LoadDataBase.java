package com.example.fun4demo;


import com.example.fun4demo.Model.Account;
import com.example.fun4demo.Model.RegistrationData;
import com.example.fun4demo.Model.Timesheet;
import com.example.fun4demo.Repository.AccountRepository;
import com.example.fun4demo.Repository.RegistrationDataRepository;
import com.example.fun4demo.Repository.TimesheetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class LoadDataBase {
    @Bean
    CommandLineRunner initDatabase(AccountRepository repository, TimesheetRepository timesheetRepository,
                                   RegistrationDataRepository registrationDataRepository) {
        return args -> {
            Account account1 = new Account("Nisreen", "Ajdad", false, "nisreen94@gmail.com", "123" );
            Account account2;

            Timesheet timesheet1 = new Timesheet("IT Bouw", account1);
            Timesheet timesheet2 = new Timesheet( "KFC", account1);

            RegistrationData data1 = new RegistrationData("Fiex Desk drive1", "15-01-2015", "14:20", "15:00", timesheet1);
            RegistrationData data2 = new RegistrationData("Fiex Desk drive2", "10-02-2015", "11:20", "13:00", timesheet1);
            RegistrationData data3 = new RegistrationData("Fiex Desk drive3", "30-03-2015", "15:20", "16:00", timesheet1);





            log.info("Preloading" + repository.save(account1));
            log.info("Preloading" + repository.save(account2=new Account("Micheal", "Brouni", true, "micheal92@gmail.com", "qwe")));
            log.info("Preloading" + timesheetRepository.save(timesheet1));
            log.info("Preloading" + timesheetRepository.save(timesheet2));
            log.info("preloading"+ registrationDataRepository.save(data1));
            log.info("preloading"+ registrationDataRepository.save(data2));  log.info("preloading"+ registrationDataRepository.save(data3));     };
    }

}

