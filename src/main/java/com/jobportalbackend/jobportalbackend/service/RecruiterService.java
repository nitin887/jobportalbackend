package com.jobportalbackend.jobportalbackend.service;

import com.jobportalbackend.jobportalbackend.dto.RecruiterDto;

import java.util.List;

/**
 * Service interface for managing recruiters.
 * Defines CRUD operations and custom queries for recruiters.
 */
public interface RecruiterService {

    /**
     * Creates a new recruiter profile.
     * @param recruiterDto The DTO containing recruiter details.
     * @return The created RecruiterDto with generated ID.
     */
    RecruiterDto createRecruiter(RecruiterDto recruiterDto);

    /**
     * Retrieves a recruiter profile by its ID.
     * @param id The ID of the recruiter to retrieve.
     * @return The RecruiterDto if found.
     */
    RecruiterDto getRecruiterById(Long id);

    /**
     * Retrieves all recruiter profiles.
     * @return A list of all RecruiterDto objects.
     */
    List<RecruiterDto> getAllRecruiters();

    /**
     * Updates an existing recruiter profile.
     * @param id The ID of the recruiter to update.
     * @param recruiterDto The DTO containing updated recruiter details.
     * @return The updated RecruiterDto.
     */
    RecruiterDto updateRecruiter(Long id, RecruiterDto recruiterDto);

    /**
     * Deletes a recruiter profile by its ID.
     * @param id The ID of the recruiter to delete.
     */
    void deleteRecruiter(Long id);

    /**
     * Retrieves a recruiter profile by their user ID.
     * @param userId The ID of the user associated with the recruiter.
     * @return The RecruiterDto if found.
     */
    RecruiterDto getRecruiterByUserId(Long userId);

    /**
     * Retrieves a recruiter profile by their company name.
     * @param companyName The company name to search for.
     * @return The RecruiterDto if found.
     */
    RecruiterDto getRecruiterByCompanyName(String companyName);

    /**
     * Retrieves all recruiters whose company name contains a specific string (case-insensitive).
     * @param companyName The string to search for in company names.
     * @return A list of RecruiterDto objects matching the company name criteria.
     */
    List<RecruiterDto> getRecruitersByCompanyNameContaining(String companyName);
}
