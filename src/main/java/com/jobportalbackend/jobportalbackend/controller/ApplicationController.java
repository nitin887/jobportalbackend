package com.jobportalbackend.jobportalbackend.controller;

import com.jobportalbackend.jobportalbackend.dto.ApplicationDto;
import com.jobportalbackend.jobportalbackend.entity.ApplicationEnum;
import com.jobportalbackend.jobportalbackend.service.ApplicationService;
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
@RequestMapping("/api/applications")
@Tag(name = "Application Controller", description = "APIs for managing job applications")
@SecurityRequirement(name = "bearerAuth")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Operation(summary = "Create a new application", description = "Handles POST requests to create a new application.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Application created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<ApplicationDto> createApplication(@RequestBody ApplicationDto applicationDto) {
        ApplicationDto createdApplication = applicationService.createApplication(applicationDto);
        return new ResponseEntity<>(createdApplication, HttpStatus.CREATED);
    }

    @Operation(summary = "Get an application by ID", description = "Handles GET requests to retrieve an application by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application found"),
            @ApiResponse(responseCode = "404", description = "Application not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDto> getApplicationById(@PathVariable Long id) {
        ApplicationDto applicationDto = applicationService.getApplicationById(id);
        return ResponseEntity.ok(applicationDto);
    }

    @Operation(summary = "Get all applications", description = "Handles GET requests to retrieve all applications.")
    @ApiResponse(responseCode = "200", description = "List of all applications")
    @GetMapping
    public ResponseEntity<List<ApplicationDto>> getAllApplications() {
        List<ApplicationDto> applications = applicationService.getAllApplications();
        return ResponseEntity.ok(applications);
    }

    @Operation(summary = "Update an application", description = "Handles PUT requests to update an existing application.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application updated successfully"),
            @ApiResponse(responseCode = "404", description = "Application not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDto> updateApplication(@PathVariable Long id, @RequestBody ApplicationDto applicationDto) {
        ApplicationDto updatedApplication = applicationService.updateApplication(id, applicationDto);
        return ResponseEntity.ok(updatedApplication);
    }

    @Operation(summary = "Delete an application", description = "Handles DELETE requests to delete an application by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Application deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Application not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get applications by user ID", description = "Handles GET requests to retrieve applications by user ID.")
    @ApiResponse(responseCode = "200", description = "List of applications for the specified user")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ApplicationDto>> getApplicationsByUserId(@PathVariable Long userId) {
        List<ApplicationDto> applications = applicationService.getApplicationsByUserId(userId);
        return ResponseEntity.ok(applications);
    }

    @Operation(summary = "Get applications by job ID", description = "Handles GET requests to retrieve applications by job ID.")
    @ApiResponse(responseCode = "200", description = "List of applications for the specified job")
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<ApplicationDto>> getApplicationsByJobId(@PathVariable Long jobId) {
        List<ApplicationDto> applications = applicationService.getApplicationsByJobId(jobId);
        return ResponseEntity.ok(applications);
    }

    @Operation(summary = "Get applications by status", description = "Handles GET requests to retrieve applications by status.")
    @ApiResponse(responseCode = "200", description = "List of applications with the specified status")
    @GetMapping("/status/{status}")
    public ResponseEntity<List<ApplicationDto>> getApplicationsByStatus(@PathVariable ApplicationEnum status) {
        List<ApplicationDto> applications = applicationService.getApplicationsByStatus(status);
        return ResponseEntity.ok(applications);
    }

    @Operation(summary = "Get an application by user ID and job ID", description = "Handles GET requests to retrieve a specific application by user ID and job ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Application found"),
            @ApiResponse(responseCode = "404", description = "Application not found")
    })
    @GetMapping("/user/{userId}/job/{jobId}")
    public ResponseEntity<ApplicationDto> getApplicationByUserIdAndJobId(@PathVariable Long userId, @PathVariable Long jobId) {
        ApplicationDto applicationDto = applicationService.getApplicationByUserIdAndJobId(userId, jobId);
        return ResponseEntity.ok(applicationDto);
    }

    @Operation(summary = "Get applications by user ID and status", description = "Handles GET requests to retrieve applications by user ID and status.")
    @ApiResponse(responseCode = "200", description = "List of applications for the specified user and status")
    @GetMapping("/user/{userId}/status/{status}")
    public ResponseEntity<List<ApplicationDto>> getApplicationsByUserIdAndStatus(@PathVariable Long userId, @PathVariable ApplicationEnum status) {
        List<ApplicationDto> applications = applicationService.getApplicationsByUserIdAndStatus(userId, status);
        return ResponseEntity.ok(applications);
    }
}