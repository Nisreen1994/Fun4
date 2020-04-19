package com.example.fun4demo.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class RegistrationData {
    private @Id @GeneratedValue long id;
    private String activity;
    private String date;
    private String startTime;
    private String endTime;
    private String description;
    @ManyToOne
    @JsonBackReference
    private Timesheet timesheet;

    public RegistrationData(){}

    public RegistrationData(String activity, String date, String startTime, String endTime, Timesheet timesheet) {
        this.activity=activity;
        this.date=date;
        this.startTime=startTime;
        this.endTime=endTime;
        this.timesheet=timesheet;

    }



    @Override
    public String toString(){
        return "RegistrationData [ id" + id + "activity" + activity + "date" + date + "startDate" + startTime
                + "endDate" + endTime +"]";
    }



}
