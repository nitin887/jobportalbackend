package com.jobportalbackend.jobportalbackend.service.impl;

import com.jobportalbackend.jobportalbackend.dto.ApplicationDto;
import com.jobportalbackend.jobportalbackend.entity.Application;
import com.jobportalbackend.jobportalbackend.entity.ApplicationEnum;
import com.jobportalbackend.jobportalbackend.exception.ApplicationNotFoundException;
import com.jobportalbackend.jobportalbackend.mapper.ApplicationMapper;
import com.jobportalbackend.jobportalbackend.repository.ApplicationRepository;
import com.jobportalbackend.jobportalbackend.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the ApplicationService interface.
 * Handles business logic for job applications.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    /**
     * Creates a new job application.
     * Converts DTO to entity, saves, and converts back to DTO.
     * @param applicationDto The DTO containing application details.
     * @return The created ApplicationDto with generated ID.
     */
    @Override
    public ApplicationDto createApplication(ApplicationDto applicationDto) {
        Application application = ApplicationMapper.toEntity(applicationDto);
        Application savedApplication = applicationRepository.save(application);
        return ApplicationMapper.toDto(savedApplication);
    }

    /**
     * Retrieves a job application by its ID.
     * @param id The ID of the application to retrieve.
     * @return The ApplicationDto if found.
     * @throws ApplicationNotFoundException if the application is not found.
     */
    @Override
    public ApplicationDto getApplicationById(Long id) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("Application not found with id: " + id));
        return ApplicationMapper.toDto(application);
    }

    /**
     * Retrieves all job applications.
     * @return A list of all ApplicationDto objects.
     */
    @Override
    public List<ApplicationDto> getAllApplications() {
        List<Application> applications = applicationRepository.findAll();
        return applications.stream()
                .map(ApplicationMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing job application.
     * @param id The ID of the application to update.
     * @param applicationDto The DTO containing updated application details.
     * @return The updated ApplicationDto.
     * @throws ApplicationNotFoundException if the application is not found.
     */
    @Override
    public ApplicationDto updateApplication(Long id, ApplicationDto applicationDto) {
        Application existingApplication = applicationRepository.findById(id)
                .orElseThrow(() -> new ApplicationNotFoundException("Application not found with id: " + id));

        // Update fields from DTO to existing entity
        existingApplication.setJob(ApplicationMapper.toEntity(applicationDto).getJob()); // Assuming job is updated via ID
        existingApplication.setUser(ApplicationMapper.toEntity(applicationDto).getUser()); // Assuming user is updated via ID
        existingApplication.setApplicationEnum(applicationDto.getApplicationEnum());
        existingApplication.setApplied_at(applicationDto.getApplied_at());

        Application updatedApplication = applicationRepository.save(existingApplication);
        return ApplicationMapper.toDto(updatedApplication);
    }

    /**
     * Deletes a job application by its ID.
     * @param id The ID of the application to delete.
     * @throws ApplicationNotFoundException if the application is not found.
     */
    @Override
    public void deleteApplication(Long id) {
        if (!applicationRepository.existsById(id)) {
            throw new ApplicationNotFoundException("Application not found with id: " + id);
        }
        applicationRepository.deleteById(id);
    }

    /**
     * Retrieves all applications submitted by a specific user.
     * @param userId The ID of the user.
     * @return A list of ApplicationDto objects for the given user.
     */
    @Override
    public List<ApplicationDto> getApplicationsByUserId(Long userId) {
        List<Application> applications = applicationRepository.findByUserId(userId);
        return applications.stream()
                .map(ApplicationMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all applications for a specific job.
     * @param jobId The ID of the job.
     * @return A list of ApplicationDto objects for the given job.
     */
    @Override
    public List<ApplicationDto> getApplicationsByJobId(Long jobId) {
        List<Application> applications = applicationRepository.findByJobId(jobId);
        return applications.stream()
                .map(ApplicationMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all applications with a specific status.
     * @param status The status of the application (e.g., APPLIED, SELECTED, PENDING).
     * @return A list of ApplicationDto objects with the given status.
     */
    @Override
    public List<ApplicationDto> getApplicationsByStatus(ApplicationEnum status) {
        List<Application> applications = applicationRepository.findByApplicationEnum(status);
        return applications.stream()
                .map(ApplicationMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a specific application by user ID and job ID.
     * @param userId The ID of the user.
     * @param jobId The ID of the job.
     * @return The ApplicationDto if found.
     * @throws ApplicationNotFoundException if the application is not found.
     */
    @Override
    public ApplicationDto getApplicationByUserIdAndJobId(Long userId, Long jobId) {
        Application application = applicationRepository.findByUserIdAndJobId(userId, jobId)
                .orElseThrow(() -> new ApplicationNotFoundException("Application not found for user id: " + userId + " and job id: " + jobId));
        return ApplicationMapper.toDto(application);
    }

    /**
     * Retrieves all applications by a user with a specific status.
     * @param userId The ID of the user.
     * @param status The status of the application.
     * @return A list of ApplicationDto objects for the given user and status.
     */
    @Override
    public List<ApplicationDto> getApplicationsByUserIdAndStatus(Long userId, ApplicationEnum status) {
        List<Application> applications = applicationRepository.findByUserIdAndApplicationEnum(userId, status);
        return applications.stream()
                .map(ApplicationMapper::toDto)
                .collect(Collectors.toList());
    }
}
