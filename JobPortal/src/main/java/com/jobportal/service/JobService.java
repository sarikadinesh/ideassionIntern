package com.jobportal.service;

import com.jobportal.model.Job;
import com.jobportal.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    // Get all jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Create a new job
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    // Get a job by ID
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));
    }

    // Update an existing job
    public Job updateJob(Long id, Job job) {
        Job existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id " + id));

        existingJob.setTitle(job.getTitle());
        existingJob.setDescription(job.getDescription());
        // Set other fields as necessary
        return jobRepository.save(existingJob);
    }

    // Delete a job by ID
    public void deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new RuntimeException("Job not found with id " + id);
        }
        jobRepository.deleteById(id);
    }
}
