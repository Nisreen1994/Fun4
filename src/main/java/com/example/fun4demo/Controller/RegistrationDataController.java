package com.example.fun4demo.Controller;

import com.example.fun4demo.Model.RegistrationData;
import com.example.fun4demo.Model.Timesheet;
import com.example.fun4demo.Repository.AccountRepository;
import com.example.fun4demo.Repository.RegistrationDataRepository;
import com.example.fun4demo.Repository.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin( maxAge = 3600, allowedHeaders = "*")
@RestController
@RequestMapping // This means URL's start with /demo (after Application path)

public class RegistrationDataController {
    @Autowired
    private RegistrationDataRepository registrationDataRepository;
    @Autowired
    private TimesheetRepository timesheetRepository;

    @GetMapping("timesheet/{timesheetId}/data")
    public @ResponseBody
    List<RegistrationData> getRegistrationDataByTimesheetProject(@PathVariable Long timesheetId ) {
        // This returns a JSON or XML with the users
        return registrationDataRepository.findByTimesheetId(timesheetId);
    }
    @PostMapping("/timesheet/{timesheetId}/data")
    public @ResponseBody RegistrationData addRegistrationData
            (@PathVariable Long timesheetId,@Valid @RequestBody RegistrationData registrationData
            ) {
        // TODO 2) het is altijd de backend die de controles doet.
       return   timesheetRepository.findById(timesheetId).map(timesheet -> {
            registrationData.setTimesheet(timesheet);
           return registrationDataRepository.save(registrationData);}).orElseThrow();

        

        // TODO 2 mogelijkheden: het bestond al, of is nieuw aangemaakt.
        // TODO 3 voorlopig mag je van mij hier een json response teruggeven, maar het is veel netter om met HTTP status codes te werken.
    }
    @PutMapping("/timesheet/{timesheetId}/data/{dataId}")
    public RegistrationData updateData (@PathVariable Long timesheetId,
                                      @PathVariable Long dataId,
                                      @Valid @RequestBody RegistrationData dataUpdated){
        return registrationDataRepository.findById(dataId).map(data ->
        {
            if (dataUpdated.getActivity() == null){
                data.setActivity(data.getActivity());
            }
            else {
                data.setActivity(dataUpdated.getActivity());
            }
            if (dataUpdated.getDate() == null) {
                data.setDate(data.getDate());
            }
            else{
                data.setDate(dataUpdated.getDate());
            }
            if (dataUpdated.getStartTime() == null) {
                data.setStartTime(data.getStartTime());
            }
            else {
                data.setStartTime(dataUpdated.getStartTime());
            }
            if (dataUpdated.getEndTime() == null) {
                data.setEndTime(data.getEndTime());
            }
            else {
                data.setEndTime(dataUpdated.getEndTime());
            }
            if (dataUpdated.getDescription() == null){
                data.setDescription(data.getDescription());
            }
            else {
                data.setDescription(dataUpdated.getDescription());
            }
            return registrationDataRepository.save(data);

        }).orElseThrow();
    }
    @DeleteMapping("timesheet/{timesheetId}/data/{dataId}")
    public String deleteTimesheet(@PathVariable Long timesheetId,
                                  @PathVariable Long dataId) {
        return registrationDataRepository.findById(dataId).map(data -> {
            registrationDataRepository.delete(data);
            return "Deleted";
        }).orElseThrow();
    }
}
