package com.example.fun4demo;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
public class Timesheet {
    private @Id @GeneratedValue long id;
    @OneToOne
    private Account account;
    @OneToMany (mappedBy = "timesheet")
    private List<RegistrationData> registrationDataList;
    public Timesheet(){}
    Timesheet(Account account){
        this.account= account;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    @Override
    public String toString(){
        return "Timesheet [ id " + id + "Account" + this.account.getId()+ "]";
    }



}
