package com.jobportalbackend.jobportalbackend.controller;

import com.jobportalbackend.jobportalbackend.dto.JobDto;
import com.jobportalbackend.jobportalbackend.service.JobService;
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
@RequestMapping("/api/jobs")
@Tag(name = "Job Controller", description = "APIs for managing job postings")
@SecurityRequirement(name = "bearerAuth")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @Operation(summary = "Create a new job posting", description = "Handles POST requests to create a new job posting.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Job posting created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<JobDto> createJob(@RequestBody JobDto jobDto) {
        JobDto createdJob = jobService.createJob(jobDto);
        return new ResponseEntity<>(createdJob, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a job posting by ID", description = "Handles GET requests to retrieve a job posting by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Job posting found"),
            @ApiResponse(responseCode = "404", description = "Job not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<JobDto> getJobById(@PathVariable Long id) {
        JobDto jobDto = jobService.getJobById(id);
        return ResponseEntity.ok(jobDto);
    }

    @Operation(summary = "Get all job postings", description = "Handles GET requests to retrieve all job postings.")
    @ApiResponse(responseCode = "200", description = "List of all job postings")
    @GetMapping
    public ResponseEntity<List<JobDto>> getAllJobs() {
        List<JobDto> jobs = jobService.getAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @Operation(summary = "Update a job posting", description = "Handles PUT requests to update an existing job posting.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Job posting updated successfully"),
            @ApiResponse(responseCode = "404", description = "Job not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<JobDto> updateJob(@PathVariable Long id, @RequestBody JobDto jobDto) {
        JobDto updatedJob = jobService.updateJob(id, jobDto);
        return ResponseEntity.ok(updatedJob);
    }

    @Operation(summary = "Delete a job posting", description = "Handles DELETE requests to delete a job posting by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Job posting deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Job not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get job postings by location", description = "Handles GET requests to retrieve job postings by location.")
    @ApiResponse(responseCode = "200", description = "List of job postings in the specified location")
    @GetMapping("/location/{location}")
    public ResponseEntity<List<JobDto>> getJobsByLocation(@PathVariable String location) {
        List<JobDto> jobs = jobService.getJobsByLocation(location);
        return ResponseEntity.ok(jobs);
    }

    @Operation(summary = "Search job postings by title", description = "Handles GET requests to retrieve job postings by title containing a specific string.")
    @ApiResponse(responseCode = "200", description = "List of job postings with the specified title")
    @GetMapping("/search/title")
    public ResponseEntity<List<JobDto>> getJobsByTitleContaining(@RequestParam String title) {
        List<JobDto> jobs = jobService.getJobsByTitleContaining(title);
        return ResponseEntity.ok(jobs);
    }

    @Operation(summary = "Search job postings by location and title", description = "Handles GET requests to retrieve job postings by location and title containing a specific string.")
    @ApiResponse(responseCode = "200", description = "List of job postings in the specified location and with the specified title")
    @GetMapping("/search")
    public ResponseEntity<List<JobDto>> getJobsByLocationAndTitleContaining(@RequestParam String location, @RequestParam String title) {
        List<JobDto> jobs = jobService.getJobsByLocationAndTitleContaining(location, title);
        return ResponseEntity.ok(jobs);
    }
}