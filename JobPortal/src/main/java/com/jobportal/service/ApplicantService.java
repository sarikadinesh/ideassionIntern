package com.jobportal.service;

import com.jobportal.model.Applicant;
import com.jobportal.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {
    private final ApplicantRepository applicantRepository;

    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    // Get all applicants
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    // Create a new applicant
    public Applicant createApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    // Get an applicant by ID
    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found with id " + id));
    }

    // Update an existing applicant
    public Applicant updateApplicant(Long id, Applicant applicant) {
        Applicant existingApplicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant not found with id " + id));

        existingApplicant.setName(applicant.getName());
        existingApplicant.setEmail(applicant.getEmail());
        // Set other fields as necessary
        return applicantRepository.save(existingApplicant);
    }

    // Delete an applicant by ID
    public void deleteApplicant(Long id) {
        if (!applicantRepository.existsById(id)) {
            throw new RuntimeException("Applicant not found with id " + id);
        }
        applicantRepository.deleteById(id);
    }
}
