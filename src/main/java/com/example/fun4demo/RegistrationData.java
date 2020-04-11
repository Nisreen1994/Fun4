package com.example.fun4demo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class RegistrationData {
    private @Id @GeneratedValue long id;
    private String activity;
    private String date;
    private String startDate;
    private String endDate;
    private String description;
    @ManyToOne
    private Timesheet timesheet;

    public RegistrationData(){}
    RegistrationData
            ( String activity, String date , String startDate , String endDate,
              String description , Timesheet timesheet)
    {

        this.activity=activity;
        this.date=date;
        this.startDate=startDate;
        this.endDate=endDate;
        this.description=description;
        this.timesheet=timesheet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String getStartDate(){return startDate;}

    public void setStartDate(String startDate){
        this.startDate=startDate;
    }
    public String getEndDate(){return endDate;}

    public void setEndDate(String endDate){
        this.endDate=endDate;
    }
    public String getDescription(){return description;}

    public void setDescription(String description){
        this.description=description;
    }
    public Timesheet getTimesheet(){
        return timesheet;
    }
    public void setTimesheet (Timesheet timesheet){
        this.timesheet=timesheet;
    }



}
