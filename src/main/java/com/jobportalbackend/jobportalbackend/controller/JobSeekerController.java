package com.jobportalbackend.jobportalbackend.controller;

import com.jobportalbackend.jobportalbackend.dto.JobSeekerDto;
import com.jobportalbackend.jobportalbackend.service.JobSeekerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobseekers")
@Tag(name = "Job Seeker Controller", description = "APIs for managing job seeker profiles")
@SecurityRequirement(name = "bearerAuth")
public class JobSeekerController {

    private final JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @Operation(summary = "Create a new job seeker profile", description = "Handles POST requests to create a new job seeker profile.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Job seeker profile created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<JobSeekerDto> createJobSeeker(@RequestBody JobSeekerDto jobSeekerDto) {
        JobSeekerDto createdJobSeeker = jobSeekerService.createJobSeeker(jobSeekerDto);
        return new ResponseEntity<>(createdJobSeeker, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a job seeker by ID", description = "Handles GET requests to retrieve a job seeker profile by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Job seeker profile found"),
            @ApiResponse(responseCode = "404", description = "Job seeker not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<JobSeekerDto> getJobSeekerById(@PathVariable Long id) {
        JobSeekerDto jobSeekerDto = jobSeekerService.getJobSeekerById(id);
        return ResponseEntity.ok(jobSeekerDto);
    }

    @Operation(summary = "Get all job seekers", description = "Handles GET requests to retrieve all job seeker profiles.")
    @ApiResponse(responseCode = "200", description = "List of all job seeker profiles")
    @GetMapping
    public ResponseEntity<List<JobSeekerDto>> getAllJobSeekers() {
        List<JobSeekerDto> jobSeekers = jobSeekerService.getAllJobSeekers();
        return ResponseEntity.ok(jobSeekers);
    }

    @Operation(summary = "Update a job seeker profile", description = "Handles PUT requests to update an existing job seeker profile.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Job seeker profile updated successfully"),
            @ApiResponse(responseCode = "404", description = "Job seeker not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<JobSeekerDto> updateJobSeeker(@PathVariable Long id, @RequestBody JobSeekerDto jobSeekerDto) {
        JobSeekerDto updatedJobSeeker = jobSeekerService.updateJobSeeker(id, jobSeekerDto);
        return ResponseEntity.ok(updatedJobSeeker);
    }

    @Operation(summary = "Delete a job seeker profile", description = "Handles DELETE requests to delete a job seeker profile by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Job seeker profile deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Job seeker not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJobSeeker(@PathVariable Long id) {
        jobSeekerService.deleteJobSeeker(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get a job seeker by user ID", description = "Handles GET requests to retrieve a job seeker profile by user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Job seeker profile found"),
            @ApiResponse(responseCode = "404", description = "Job seeker not found")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<JobSeekerDto> getJobSeekerByUserId(@PathVariable Long userId) {
        JobSeekerDto jobSeekerDto = jobSeekerService.getJobSeekerByUserId(userId);
        return ResponseEntity.ok(jobSeekerDto);
    }

    @Operation(summary = "Search job seekers by skill", description = "Handles GET requests to retrieve job seekers whose skills contain a specific string.")
    @ApiResponse(responseCode = "200", description = "List of job seekers with the specified skill")
    @GetMapping("/search/skill")
    public ResponseEntity<List<JobSeekerDto>> getJobSeekersBySkill(@RequestParam String skill) {
        List<JobSeekerDto> jobSeekers = jobSeekerService.getJobSeekersBySkill(skill);
        return ResponseEntity.ok(jobSeekers);
    }

    @Operation(summary = "Search job seekers by experience", description = "Handles GET requests to retrieve job seekers whose experience contains a specific string.")
    @ApiResponse(responseCode = "200", description = "List of job seekers with the specified experience")
    @GetMapping("/search/experience")
    public ResponseEntity<List<JobSeekerDto>> getJobSeekersByExperience(@RequestParam String experience) {
        List<JobSeekerDto> jobSeekers = jobSeekerService.getJobSeekersByExperience(experience);
        return ResponseEntity.ok(jobSeekers);
    }
}