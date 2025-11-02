package com.jobportalbackend.jobportalbackend.service;

import com.jobportalbackend.jobportalbackend.dto.ApplicationDto;
import com.jobportalbackend.jobportalbackend.entity.ApplicationEnum;

import java.util.List;

/**
 * Service interface for managing job applications.
 * Defines CRUD operations and custom queries for applications.
 */
public interface ApplicationService {

    /**
     * Creates a new job application.
     * @param applicationDto The DTO containing application details.
     * @return The created ApplicationDto with generated ID.
     */
    ApplicationDto createApplication(ApplicationDto applicationDto);

    /**
     * Retrieves a job application by its ID.
     * @param id The ID of the application to retrieve.
     * @return An Optional containing the ApplicationDto if found, otherwise empty.
     */
    ApplicationDto getApplicationById(Long id);

    /**
     * Retrieves all job applications.
     * @return A list of all ApplicationDto objects.
     */
    List<ApplicationDto> getAllApplications();

    /**
     * Updates an existing job application.
     * @param id The ID of the application to update.
     * @param applicationDto The DTO containing updated application details.
     * @return The updated ApplicationDto.
     */
    ApplicationDto updateApplication(Long id, ApplicationDto applicationDto);

    /**
     * Deletes a job application by its ID.
     * @param id The ID of the application to delete.
     */
    void deleteApplication(Long id);

    /**
     * Retrieves all applications submitted by a specific user.
     * @param userId The ID of the user.
     * @return A list of ApplicationDto objects for the given user.
     */
    List<ApplicationDto> getApplicationsByUserId(Long userId);

    /**
     * Retrieves all applications for a specific job.
     * @param jobId The ID of the job.
     * @return A list of ApplicationDto objects for the given job.
     */
    List<ApplicationDto> getApplicationsByJobId(Long jobId);

    /**
     * Retrieves all applications with a specific status.
     * @param status The status of the application (e.g., APPLIED, SELECTED, PENDING).
     * @return A list of ApplicationDto objects with the given status.
     */
    List<ApplicationDto> getApplicationsByStatus(ApplicationEnum status);

    /**
     * Retrieves a specific application by user ID and job ID.
     * @param userId The ID of the user.
     * @param jobId The ID of the job.
     * @return An Optional containing the ApplicationDto if found, otherwise empty.
     */
    ApplicationDto getApplicationByUserIdAndJobId(Long userId, Long jobId);

    /**
     * Retrieves all applications by a user with a specific status.
     * @param userId The ID of the user.
     * @param status The status of the application.
     * @return A list of ApplicationDto objects for the given user and status.
     */
    List<ApplicationDto> getApplicationsByUserIdAndStatus(Long userId, ApplicationEnum status);
}
