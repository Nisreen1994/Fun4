package com.example.fun4demo.Repository;

import com.example.fun4demo.Model.RegistrationData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationDataRepository extends JpaRepository<RegistrationData , Long> {
    List<RegistrationData> findByTimesheetId(Long timesheetId);
}
