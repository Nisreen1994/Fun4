package com.example.fun4demo.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table
public class Timesheet {
    private @Id @GeneratedValue long id;
    @NotEmpty
    private String project;
    @ManyToOne
    @JsonBackReference //This annotation basically says that a account will not be part of the JSON returned for timesheet
    // (but each account will contain list of its timesheet in the response
    private Account account;
    @OneToMany(mappedBy = "timesheet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RegistrationData> registrationDataList;
    public Timesheet(){}
    public Timesheet(String project, Account account){

        this.project=project;
        this.account=account;
    }


    @Override
    public String toString(){
        return "Timesheet [ id " + id + "project"+project+ "]";
    }



}
