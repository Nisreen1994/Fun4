package com.example.fun4demo.Repository;

import com.example.fun4demo.Model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimesheetRepository extends JpaRepository <Timesheet,Long> {
List<Timesheet> findByAccountId(Long accountId);
}
