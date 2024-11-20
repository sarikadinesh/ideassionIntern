package com.jobportal.controller;

import com.jobportal.model.Recruiter;
import com.jobportal.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    // GET request - Retrieve all recruiters
    @GetMapping
    public List<Recruiter> getAllRecruiters() {
        return recruiterService.getAllRecruiters();
    }

    // POST request - Create a new recruiter
    @PostMapping
    public Recruiter createRecruiter(@RequestBody Recruiter recruiter) {
        return recruiterService.createRecruiter(recruiter);
    }

    // GET request by ID - Retrieve a recruiter by ID
    @GetMapping("/{id}")
    public Recruiter getRecruiterById(@PathVariable Long id) {
        return recruiterService.getRecruiterById(id);
    }

    // PUT request - Update an existing recruiter
    @PutMapping("/{id}")
    public Recruiter updateRecruiter(@PathVariable Long id, @RequestBody Recruiter recruiter) {
        return recruiterService.updateRecruiter(id, recruiter);
    }

    // DELETE request - Delete a recruiter by ID
    @DeleteMapping("/{id}")
    public void deleteRecruiter(@PathVariable Long id) {
        recruiterService.deleteRecruiter(id);
    }
}
