package com.jobportalbackend.jobportalbackend.service;

import com.jobportalbackend.jobportalbackend.dto.JobDto;

import java.util.List;

/**
 * Service interface for managing job postings.
 * Defines CRUD operations and custom queries for jobs.
 */
public interface JobService {

    /**
     * Creates a new job posting.
     * @param jobDto The DTO containing job details.
     * @return The created JobDto with generated ID.
     */
    JobDto createJob(JobDto jobDto);

    /**
     * Retrieves a job posting by its ID.
     * @param id The ID of the job to retrieve.
     * @return The JobDto if found.
     */
    JobDto getJobById(Long id);

    /**
     * Retrieves all job postings.
     * @return A list of all JobDto objects.
     */
    List<JobDto> getAllJobs();

    /**
     * Updates an existing job posting.
     * @param id The ID of the job to update.
     * @param jobDto The DTO containing updated job details.
     * @return The updated JobDto.
     */
    JobDto updateJob(Long id, JobDto jobDto);

    /**
     * Deletes a job posting by its ID.
     * @param id The ID of the job to delete.
     */
    void deleteJob(Long id);

    /**
     * Retrieves all job postings in a specific location.
     * @param location The location to search for jobs.
     * @return A list of JobDto objects for the given location.
     */
    List<JobDto> getJobsByLocation(String location);

    /**
     * Retrieves all job postings with a title containing a specific string (case-insensitive).
     * @param title The string to search for in job titles.
     * @return A list of JobDto objects matching the title criteria.
     */
    List<JobDto> getJobsByTitleContaining(String title);

    /**
     * Retrieves all job postings in a specific location and with a title containing a specific string (case-insensitive).
     * @param location The location to search for jobs.
     * @param title The string to search for in job titles.
     * @return A list of JobDto objects matching both location and title criteria.
     */
    List<JobDto> getJobsByLocationAndTitleContaining(String location, String title);
}
