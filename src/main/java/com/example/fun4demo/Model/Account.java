package com.example.fun4demo.Model;

import com.example.fun4demo.Model.Timesheet;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
public class Account {

    private @Id @GeneratedValue long id;
    private String firstName;

    private String lastName;
    private Boolean staffMember;
    private String password;
    @Email
    private String email;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Timesheet> timesheetsList;
    public Account(){}
    //Account constructor: This constructor will be used when we supply form data to the controller.
    public Account(String firstName, String lastName, Boolean staffMember, String email, String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.staffMember=staffMember;
        this.email=email;
        this.password=password;

    }




    @Override
    public String toString (){
        return "Account [id"+ id + ", firstName" + firstName + ", lastName"+ lastName + ", staffMember"+ staffMember +
                ", email"+ email + ", password" + password +"]";
    }


}
