package com.jobportalbackend.jobportalbackend.service.impl;

import com.jobportalbackend.jobportalbackend.dto.JobSeekerDto;
import com.jobportalbackend.jobportalbackend.entity.JobSeeker;
import com.jobportalbackend.jobportalbackend.exception.JobSeekerNotFoundException;
import com.jobportalbackend.jobportalbackend.mapper.JobSeekerMapper;
import com.jobportalbackend.jobportalbackend.repository.JobSeekerRepository;
import com.jobportalbackend.jobportalbackend.service.JobSeekerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the JobSeekerService interface.
 * Handles business logic for job seekers.
 */
@Service
public class JobSeekerServiceImpl implements JobSeekerService {

    private final JobSeekerRepository jobSeekerRepository;

    public JobSeekerServiceImpl(JobSeekerRepository jobSeekerRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
    }

    /**
     * Creates a new job seeker profile.
     * Converts DTO to entity, saves, and converts back to DTO.
     * @param jobSeekerDto The DTO containing job seeker details.
     * @return The created JobSeekerDto with generated ID.
     */
    @Override
    public JobSeekerDto createJobSeeker(JobSeekerDto jobSeekerDto) {
        JobSeeker jobSeeker = JobSeekerMapper.toEntity(jobSeekerDto);
        JobSeeker savedJobSeeker = jobSeekerRepository.save(jobSeeker);
        return JobSeekerMapper.toDto(savedJobSeeker);
    }

    /**
     * Retrieves a job seeker profile by its ID.
     * @param id The ID of the job seeker to retrieve.
     * @return The JobSeekerDto if found.
     * @throws JobSeekerNotFoundException if the job seeker is not found.
     */
    @Override
    public JobSeekerDto getJobSeekerById(Long id) {
        JobSeeker jobSeeker = jobSeekerRepository.findById(id)
                .orElseThrow(() -> new JobSeekerNotFoundException("JobSeeker not found with id: " + id));
        return JobSeekerMapper.toDto(jobSeeker);
    }

    /**
     * Retrieves all job seeker profiles.
     * @return A list of all JobSeekerDto objects.
     */
    @Override
    public List<JobSeekerDto> getAllJobSeekers() {
        List<JobSeeker> jobSeekers = jobSeekerRepository.findAll();
        return jobSeekers.stream()
                .map(JobSeekerMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing job seeker profile.
     * @param id The ID of the job seeker to update.
     * @param jobSeekerDto The DTO containing updated job seeker details.
     * @return The updated JobSeekerDto.
     * @throws JobSeekerNotFoundException if the job seeker is not found.
     */
    @Override
    public JobSeekerDto updateJobSeeker(Long id, JobSeekerDto jobSeekerDto) {
        JobSeeker existingJobSeeker = jobSeekerRepository.findById(id)
                .orElseThrow(() -> new JobSeekerNotFoundException("JobSeeker not found with id: " + id));

        // Update fields from DTO to existing entity
        existingJobSeeker.setUser(JobSeekerMapper.toEntity(jobSeekerDto).getUser()); // Assuming user is updated via ID
        existingJobSeeker.setResume_url(jobSeekerDto.getResume_url());
        existingJobSeeker.setSkills(jobSeekerDto.getSkills());
        existingJobSeeker.setExperience(jobSeekerDto.getExperience());

        JobSeeker updatedJobSeeker = jobSeekerRepository.save(existingJobSeeker);
        return JobSeekerMapper.toDto(updatedJobSeeker);
    }

    /**
     * Deletes a job seeker profile by its ID.
     * @param id The ID of the job seeker to delete.
     * @throws JobSeekerNotFoundException if the job seeker is not found.
     */
    @Override
    public void deleteJobSeeker(Long id) {
        if (!jobSeekerRepository.existsById(id)) {
            throw new JobSeekerNotFoundException("JobSeeker not found with id: " + id);
        }
        jobSeekerRepository.deleteById(id);
    }

    /**
     * Retrieves a job seeker profile by their user ID.
     * @param userId The ID of the user associated with the job seeker.
     * @return The JobSeekerDto if found.
     * @throws JobSeekerNotFoundException if the job seeker is not found.
     */
    @Override
    public JobSeekerDto getJobSeekerByUserId(Long userId) {
        JobSeeker jobSeeker = jobSeekerRepository.findByUserId(userId)
                .orElseThrow(() -> new JobSeekerNotFoundException("JobSeeker not found for user id: " + userId));
        return JobSeekerMapper.toDto(jobSeeker);
    }

    /**
     * Retrieves all job seekers whose skills contain a specific string (case-insensitive).
     * @param skill The string to search for in job seeker skills.
     * @return A list of JobSeekerDto objects matching the skill criteria.
     */
    @Override
    public List<JobSeekerDto> getJobSeekersBySkill(String skill) {
        List<JobSeeker> jobSeekers = jobSeekerRepository.findBySkillsContainingIgnoreCase(skill);
        return jobSeekers.stream()
                .map(JobSeekerMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all job seekers whose experience contains a specific string (case-insensitive).
     * @param experience The string to search for in job seeker experience.
     * @return A list of JobSeekerDto objects matching the experience criteria.
     */
    @Override
    public List<JobSeekerDto> getJobSeekersByExperience(String experience) {
        List<JobSeeker> jobSeekers = jobSeekerRepository.findByExperienceContainingIgnoreCase(experience);
        return jobSeekers.stream()
                .map(JobSeekerMapper::toDto)
                .collect(Collectors.toList());
    }
}
