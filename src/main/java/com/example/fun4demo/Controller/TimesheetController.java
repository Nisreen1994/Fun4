package com.example.fun4demo.Controller;


import com.example.fun4demo.Model.Account;
import com.example.fun4demo.Model.Timesheet;
import com.example.fun4demo.Repository.AccountRepository;
import com.example.fun4demo.Repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin( maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping
public class TimesheetController {
    @Autowired
    private TimesheetRepository timesheetRepository;
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("account/{accountId}/timesheet")
    public @ResponseBody
    List<Timesheet> getTimesheetByAccountId(@PathVariable Long accountId) {
        // This returns a JSON or XML with the users
        return timesheetRepository.findByAccountId(accountId);
    }
    @PostMapping("/account/{accountId}/timesheet")
    public @ResponseBody Timesheet addTimesheet
            (@PathVariable Long accountId,@Valid @RequestBody Timesheet timesheet
    ) {
        // TODO 2) het is altijd de backend die de controles doet.
       return accountRepository.findById(accountId).map(account -> {
            timesheet.setAccount(account);
            return timesheetRepository.save(timesheet);}).orElseThrow();

        // TODO 2 mogelijkheden: het bestond al, of is nieuw aangemaakt.
        // TODO 3 voorlopig mag je van mij hier een json response teruggeven, maar het is veel netter om met HTTP status codes te werken.
    }
    @PutMapping("/account/{accountId}/timesheet/{timesheetId}")
    public Timesheet updateTimesheet (@PathVariable Long accountId,
                                      @PathVariable Long timesheetId,
                                      @Valid @RequestBody Timesheet timesheetUpdated){
        return timesheetRepository.findById(timesheetId).map(timesheet ->
        {
            if (timesheetUpdated.getProject() == null) {
                timesheet.setProject(timesheet.getProject());
            }
            else {
                timesheet.setProject(timesheetUpdated.getProject());
            }
            return timesheetRepository.save(timesheet);

        }).orElseThrow();
    }
    @DeleteMapping("account/{accountId}/timesheet/{timesheetId}")
    public String deleteTimesheet(@PathVariable Long accountId,
                                  @PathVariable Long timesheetId) {
       return timesheetRepository.findById(timesheetId).map(timesheet -> {
          timesheetRepository.delete(timesheet);
          return "Deleted";
       }).orElseThrow();
    }
}
