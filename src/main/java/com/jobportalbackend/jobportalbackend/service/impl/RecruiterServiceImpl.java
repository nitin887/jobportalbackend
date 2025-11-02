package com.jobportalbackend.jobportalbackend.service.impl;

import com.jobportalbackend.jobportalbackend.dto.RecruiterDto;
import com.jobportalbackend.jobportalbackend.entity.Recruiter;
import com.jobportalbackend.jobportalbackend.exception.RecruiterNotFoundException;
import com.jobportalbackend.jobportalbackend.mapper.RecruiterMapper;
import com.jobportalbackend.jobportalbackend.repository.RecruiterRepository;
import com.jobportalbackend.jobportalbackend.service.RecruiterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the RecruiterService interface.
 * Handles business logic for recruiters.
 */
@Service
public class RecruiterServiceImpl implements RecruiterService {

    private final RecruiterRepository recruiterRepository;

    public RecruiterServiceImpl(RecruiterRepository recruiterRepository) {
        this.recruiterRepository = recruiterRepository;
    }

    /**
     * Creates a new recruiter profile.
     * Converts DTO to entity, saves, and converts back to DTO.
     * @param recruiterDto The DTO containing recruiter details.
     * @return The created RecruiterDto with generated ID.
     */
    @Override
    public RecruiterDto createRecruiter(RecruiterDto recruiterDto) {
        Recruiter recruiter = RecruiterMapper.toEntity(recruiterDto);
        Recruiter savedRecruiter = recruiterRepository.save(recruiter);
        return RecruiterMapper.toDto(savedRecruiter);
    }

    /**
     * Retrieves a recruiter profile by its ID.
     * @param id The ID of the recruiter to retrieve.
     * @return The RecruiterDto if found.
     * @throws RecruiterNotFoundException if the recruiter is not found.
     */
    @Override
    public RecruiterDto getRecruiterById(Long id) {
        Recruiter recruiter = recruiterRepository.findById(id)
                .orElseThrow(() -> new RecruiterNotFoundException("Recruiter not found with id: " + id));
        return RecruiterMapper.toDto(recruiter);
    }

    /**
     * Retrieves all recruiter profiles.
     * @return A list of all RecruiterDto objects.
     */
    @Override
    public List<RecruiterDto> getAllRecruiters() {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        return recruiters.stream()
                .map(RecruiterMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing recruiter profile.
     * @param id The ID of the recruiter to update.
     * @param recruiterDto The DTO containing updated recruiter details.
     * @return The updated RecruiterDto.
     * @throws RecruiterNotFoundException if the recruiter is not found.
     */
    @Override
    public RecruiterDto updateRecruiter(Long id, RecruiterDto recruiterDto) {
        Recruiter existingRecruiter = recruiterRepository.findById(id)
                .orElseThrow(() -> new RecruiterNotFoundException("Recruiter not found with id: " + id));

        // Update fields from DTO to existing entity
        existingRecruiter.setUser(RecruiterMapper.toEntity(recruiterDto).getUser()); // Assuming user is updated via ID
        existingRecruiter.setCompanyName(recruiterDto.getCompanyName());
        existingRecruiter.setContact_info(recruiterDto.getContact_info());

        Recruiter updatedRecruiter = recruiterRepository.save(existingRecruiter);
        return RecruiterMapper.toDto(updatedRecruiter);
    }

    /**
     * Deletes a recruiter profile by its ID.
     * @param id The ID of the recruiter to delete.
     * @throws RecruiterNotFoundException if the recruiter is not found.
     */
    @Override
    public void deleteRecruiter(Long id) {
        if (!recruiterRepository.existsById(id)) {
            throw new RecruiterNotFoundException("Recruiter not found with id: " + id);
        }
        recruiterRepository.deleteById(id);
    }

    /**
     * Retrieves a recruiter profile by their user ID.
     * @param userId The ID of the user associated with the recruiter.
     * @return The RecruiterDto if found.
     * @throws RecruiterNotFoundException if the recruiter is not found.
     */
    @Override
    public RecruiterDto getRecruiterByUserId(Long userId) {
        Recruiter recruiter = recruiterRepository.findByUserId(userId)
                .orElseThrow(() -> new RecruiterNotFoundException("Recruiter not found for user id: " + userId));
        return RecruiterMapper.toDto(recruiter);
    }

    /**
     * Retrieves a recruiter profile by their company name.
     * @param companyName The company name to search for.
     * @return The RecruiterDto if found.
     * @throws RecruiterNotFoundException if the recruiter is not found.
     */
    @Override
    public RecruiterDto getRecruiterByCompanyName(String companyName) {
        Recruiter recruiter = recruiterRepository.findByCompanyName(companyName)
                .orElseThrow(() -> new RecruiterNotFoundException("Recruiter not found for company name: " + companyName));
        return RecruiterMapper.toDto(recruiter);
    }

    /**
     * Retrieves all recruiters whose company name contains a specific string (case-insensitive).
     * @param companyName The string to search for in company names.
     * @return A list of RecruiterDto objects matching the company name criteria.
     */
    @Override
    public List<RecruiterDto> getRecruitersByCompanyNameContaining(String companyName) {
        List<Recruiter> recruiters = recruiterRepository.findByCompanyNameContainingIgnoreCase(companyName);
        return recruiters.stream()
                .map(RecruiterMapper::toDto)
                .collect(Collectors.toList());
    }
}
