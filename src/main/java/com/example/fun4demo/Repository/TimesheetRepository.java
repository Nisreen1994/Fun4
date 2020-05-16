package com.example.fun4demo.Repository;

import com.example.fun4demo.Model.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface TimesheetRepository extends JpaRepository <Timesheet,Long> {
List<Timesheet> findByAccountId(Long accountId);
}
