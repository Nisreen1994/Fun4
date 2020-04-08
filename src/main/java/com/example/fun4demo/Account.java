package com.example.fun4demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Account {
    private @Id @GeneratedValue long id;
    private String firstName;
    private String lastName;
    private Boolean staffMember;
    private String email;
    private String password;
    public Account(){}
    //Account constructor: This constructor will be used when we supply form data to the controller.
    Account (String firstName, String lastName,Boolean staffMember,String email,String password){
        this.firstName=firstName;
        this.lastName=lastName;
        this.staffMember=staffMember;
        this.email=email;
        this.password=password;

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
   }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getStaffMember() {
        return staffMember;
    }

    public void setStaffMember(Boolean staffMember) {
        this.staffMember = staffMember;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString (){
        return "Account [id"+ id + ", firstName" + firstName + ", lastName"+ lastName + ", staffMember"+ staffMember +
                ", email"+ email + ", password" + password +"]";
    }


}
