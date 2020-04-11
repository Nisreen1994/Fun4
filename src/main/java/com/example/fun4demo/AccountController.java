package com.example.fun4demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin( maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping(path="/account") // This means URL's start with /demo (after Application path)
public class AccountController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private AccountRepository accountRepository;
    private TimesheetRepository timesheetRepository;

    @GetMapping
    public @ResponseBody Iterable<Account> getAllAccount() {
        // This returns a JSON or XML with the users
        return accountRepository.findAll();

    }
    @PostMapping
    public @ResponseBody String addNewAccount (@Valid @RequestBody Account account
    ) {

        Account a = new Account();
        accountRepository.save(account);
        return "{Saved}";
    }
    @DeleteMapping(value = "/{id}")
    public String deleteAccount(@PathVariable long id) {
        accountRepository.deleteById(id);

        return id + " is succesfully deleted";
    }




}
