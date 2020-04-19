package com.example.fun4demo.Repository;

import com.example.fun4demo.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AccountRepository extends JpaRepository <Account,Long >{
    Account findByEmail (String email);

}
