package com.jobportalbackend.jobportalbackend.service;

import com.jobportalbackend.jobportalbackend.dto.JobSeekerDto;

import java.util.List;

/**
 * Service interface for managing job seekers.
 * Defines CRUD operations and custom queries for job seekers.
 */
public interface JobSeekerService {

    /**
     * Creates a new job seeker profile.
     * @param jobSeekerDto The DTO containing job seeker details.
     * @return The created JobSeekerDto with generated ID.
     */
    JobSeekerDto createJobSeeker(JobSeekerDto jobSeekerDto);

    /**
     * Retrieves a job seeker profile by its ID.
     * @param id The ID of the job seeker to retrieve.
     * @return The JobSeekerDto if found.
     */
    JobSeekerDto getJobSeekerById(Long id);

    /**
     * Retrieves all job seeker profiles.
     * @return A list of all JobSeekerDto objects.
     */
    List<JobSeekerDto> getAllJobSeekers();

    /**
     * Updates an existing job seeker profile.
     * @param id The ID of the job seeker to update.
     * @param jobSeekerDto The DTO containing updated job seeker details.
     * @return The updated JobSeekerDto.
     */
    JobSeekerDto updateJobSeeker(Long id, JobSeekerDto jobSeekerDto);

    /**
     * Deletes a job seeker profile by its ID.
     * @param id The ID of the job seeker to delete.
     */
    void deleteJobSeeker(Long id);

    /**
     * Retrieves a job seeker profile by their user ID.
     * @param userId The ID of the user associated with the job seeker.
     * @return The JobSeekerDto if found.
     */
    JobSeekerDto getJobSeekerByUserId(Long userId);

    /**
     * Retrieves all job seekers whose skills contain a specific string (case-insensitive).
     * @param skill The string to search for in job seeker skills.
     * @return A list of JobSeekerDto objects matching the skill criteria.
     */
    List<JobSeekerDto> getJobSeekersBySkill(String skill);

    /**
     * Retrieves all job seekers whose experience contains a specific string (case-insensitive).
     * @param experience The string to search for in job seeker experience.
     * @return A list of JobSeekerDto objects matching the experience criteria.
     */
    List<JobSeekerDto> getJobSeekersByExperience(String experience);
}
