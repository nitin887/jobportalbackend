package com.jobportalbackend.jobportalbackend.service.impl;

import com.jobportalbackend.jobportalbackend.dto.JobDto;
import com.jobportalbackend.jobportalbackend.entity.Job;
import com.jobportalbackend.jobportalbackend.exception.JobNotFoundException;
import com.jobportalbackend.jobportalbackend.mapper.JobMapper;
import com.jobportalbackend.jobportalbackend.repository.JobRepository;
import com.jobportalbackend.jobportalbackend.service.JobService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the JobService interface.
 * Handles business logic for job postings.
 */
@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    /**
     * Creates a new job posting.
     * Converts DTO to entity, saves, and converts back to DTO.
     * Sets created_at timestamp.
     * @param jobDto The DTO containing job details.
     * @return The created JobDto with generated ID.
     */
    @Override
    public JobDto createJob(JobDto jobDto) {
        Job job = JobMapper.toJobEntity(jobDto);
        job.setCreated_at(LocalDateTime.now()); // Set creation timestamp
        Job savedJob = jobRepository.save(job);
        return JobMapper.toJobDto(savedJob);
    }

    /**
     * Retrieves a job posting by its ID.
     * @param id The ID of the job to retrieve.
     * @return The JobDto if found.
     * @throws JobNotFoundException if the job is not found.
     */
    @Override
    public JobDto getJobById(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException("Job not found with id: " + id));
        return JobMapper.toJobDto(job);
    }

    /**
     * Retrieves all job postings.
     * @return A list of all JobDto objects.
     */
    @Override
    public List<JobDto> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream()
                .map(JobMapper::toJobDto)
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing job posting.
     * @param id The ID of the job to update.
     * @param jobDto The DTO containing updated job details.
     * @return The updated JobDto.
     * @throws JobNotFoundException if the job is not found.
     */
    @Override
    public JobDto updateJob(Long id, JobDto jobDto) {
        Job existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException("Job not found with id: " + id));

        // Update fields from DTO to existing entity
        existingJob.setTile(jobDto.getTile());
        existingJob.setDescription(jobDto.getDescription());
        existingJob.setLocation(jobDto.getLocation());
        existingJob.setSalary(jobDto.getSalary());
        // Note: Recruiter list update logic might be more complex depending on requirements
        // For simplicity, assuming full replacement or handled in a separate service
        existingJob.setRecruiter(JobMapper.toJobEntity(jobDto).getRecruiter());

        Job updatedJob = jobRepository.save(existingJob);
        return JobMapper.toJobDto(updatedJob);
    }

    /**
     * Deletes a job posting by its ID.
     * @param id The ID of the job to delete.
     * @throws JobNotFoundException if the job is not found.
     */
    @Override
    public void deleteJob(Long id) {
        if (!jobRepository.existsById(id)) {
            throw new JobNotFoundException("Job not found with id: " + id);
        }
        jobRepository.deleteById(id);
    }

    /**
     * Retrieves all job postings in a specific location.
     * @param location The location to search for jobs.
     * @return A list of JobDto objects for the given location.
     */
    @Override
    public List<JobDto> getJobsByLocation(String location) {
        List<Job> jobs = jobRepository.findByLocation(location);
        return jobs.stream()
                .map(JobMapper::toJobDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all job postings with a title containing a specific string (case-insensitive).
     * @param title The string to search for in job titles.
     * @return A list of JobDto objects matching the title criteria.
     */
    @Override
    public List<JobDto> getJobsByTitleContaining(String title) {
        List<Job> jobs = jobRepository.findByTile(title);
        return jobs.stream()
                .map(JobMapper::toJobDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all job postings in a specific location and with a title containing a specific string (case-insensitive).
     * @param location The location to search for jobs.
     * @param title The string to search for in job titles.
     * @return A list of JobDto objects matching both location and title criteria.
     */
    @Override
    public List<JobDto> getJobsByLocationAndTitleContaining(String location, String title) {
        List<Job> jobs = jobRepository.findByLocationAndTileContainingIgnoreCase(location, title);
        return jobs.stream()
                .map(JobMapper::toJobDto)
                .collect(Collectors.toList());
    }
}
