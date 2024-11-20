package com.jobportal.service;

import com.jobportal.model.Recruiter;
import com.jobportal.repository.RecruiterRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecruiterService {
    private final RecruiterRepository recruiterRepository;

    public RecruiterService(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    // Get all recruiters
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    // Create a new recruiter
    public Recruiter createRecruiter(Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }

    // Get a recruiter by ID
    public Recruiter getRecruiterById(Long id) {
        return recruiterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruiter not found with id " + id));
    }

    // Update an existing recruiter
    public Recruiter updateRecruiter(Long id, Recruiter recruiter) {
        Recruiter existingRecruiter = recruiterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recruiter not found with id " + id));

        // Update the existing recruiter fields
        existingRecruiter.setCompanyName(recruiter.getCompanyName());
        existingRecruiter.setContactNumber(recruiter.getContactNumber());

        return recruiterRepository.save(existingRecruiter);
    }

    // Delete a recruiter by ID
    public void deleteRecruiter(Long id) {
        if (!recruiterRepository.existsById(id)) {
            throw new RuntimeException("Recruiter not found with id " + id);
        }
        recruiterRepository.deleteById(id);
    }
}
