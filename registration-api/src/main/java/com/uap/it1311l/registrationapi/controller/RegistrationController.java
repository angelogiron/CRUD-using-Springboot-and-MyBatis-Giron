

package com.uap.it1311l.registrationapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.uap.it1311l.registrationapi.model.Attendee;
import com.uap.it1311l.registrationapi.repository.RegistrationMybatisRepository;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationMybatisRepository registrationRepo;

    @PostMapping("/event/register")
    public Attendee register(@RequestBody Attendee student) {
        registrationRepo.insert(student);
        return student;
    }

    @GetMapping("/attendees")
    public List<Attendee> getAllAttendees() {
        return registrationRepo.findAll();
    }
    
    @PutMapping("/event/survey/eligibility")
    public List<Attendee> markBSITAttendeesEligibleForSurvey() {
        registrationRepo.markBSITAttendeesEligibleForSurvey();
        return registrationRepo.findAll(); 
    }
    
    @DeleteMapping("/event/registration/{id}")
    public String deleteAttendee(@PathVariable String id) {
        int deletedRows = registrationRepo.deleteById(id);
        if (deletedRows > 0) {
            return "Record with ID " + id + " deleted successfully.";
        } else {
            return "Record with ID " + id + " not found";
        }
    }
}

