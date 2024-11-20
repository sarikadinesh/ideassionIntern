package com.jobportal.controller;

import com.jobportal.model.Applicant;
import com.jobportal.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    // GET request - Retrieve all applicants
    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantService.getAllApplicants();
    }

    // POST request - Create a new applicant
    @PostMapping
    public Applicant createApplicant(@RequestBody Applicant applicant) {
        return applicantService.createApplicant(applicant);
    }

    // GET request by ID - Retrieve an applicant by ID
    @GetMapping("/{id}")
    public Applicant getApplicantById(@PathVariable Long id) {
        return applicantService.getApplicantById(id);
    }

    // PUT request - Update an existing applicant using request param
    @PutMapping
    public Applicant updateApplicant(@RequestParam Long id, @RequestBody Applicant applicant) {
        return applicantService.updateApplicant(id, applicant);
    }

    // DELETE request - Delete an applicant by ID
    @DeleteMapping("/{id}")
    public void deleteApplicant(@PathVariable Long id) {
        applicantService.deleteApplicant(id);
    }
}
