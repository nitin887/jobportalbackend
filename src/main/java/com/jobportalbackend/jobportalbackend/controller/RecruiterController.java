package com.jobportalbackend.jobportalbackend.controller;

import com.jobportalbackend.jobportalbackend.dto.RecruiterDto;
import com.jobportalbackend.jobportalbackend.service.RecruiterService;
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
@RequestMapping("/api/recruiters")
@Tag(name = "Recruiter Controller", description = "APIs for managing recruiter profiles")
@SecurityRequirement(name = "bearerAuth")
public class RecruiterController {

    private final RecruiterService recruiterService;

    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @Operation(summary = "Create a new recruiter profile", description = "Handles POST requests to create a new recruiter profile.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Recruiter profile created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<RecruiterDto> createRecruiter(@RequestBody RecruiterDto recruiterDto) {
        RecruiterDto createdRecruiter = recruiterService.createRecruiter(recruiterDto);
        return new ResponseEntity<>(createdRecruiter, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a recruiter by ID", description = "Handles GET requests to retrieve a recruiter profile by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recruiter profile found"),
            @ApiResponse(responseCode = "404", description = "Recruiter not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<RecruiterDto> getRecruiterById(@PathVariable Long id) {
        RecruiterDto recruiterDto = recruiterService.getRecruiterById(id);
        return ResponseEntity.ok(recruiterDto);
    }

    @Operation(summary = "Get all recruiters", description = "Handles GET requests to retrieve all recruiter profiles.")
    @ApiResponse(responseCode = "200", description = "List of all recruiter profiles")
    @GetMapping
    public ResponseEntity<List<RecruiterDto>> getAllRecruiters() {
        List<RecruiterDto> recruiters = recruiterService.getAllRecruiters();
        return ResponseEntity.ok(recruiters);
    }

    @Operation(summary = "Update a recruiter profile", description = "Handles PUT requests to update an existing recruiter profile.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recruiter profile updated successfully"),
            @ApiResponse(responseCode = "404", description = "Recruiter not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<RecruiterDto> updateRecruiter(@PathVariable Long id, @RequestBody RecruiterDto recruiterDto) {
        RecruiterDto updatedRecruiter = recruiterService.updateRecruiter(id, recruiterDto);
        return ResponseEntity.ok(updatedRecruiter);
    }

    @Operation(summary = "Delete a recruiter profile", description = "Handles DELETE requests to delete a recruiter profile by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Recruiter profile deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Recruiter not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecruiter(@PathVariable Long id) {
        recruiterService.deleteRecruiter(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get a recruiter by user ID", description = "Handles GET requests to retrieve a recruiter profile by user ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recruiter profile found"),
            @ApiResponse(responseCode = "404", description = "Recruiter not found")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<RecruiterDto> getRecruiterByUserId(@PathVariable Long userId) {
        RecruiterDto recruiterDto = recruiterService.getRecruiterByUserId(userId);
        return ResponseEntity.ok(recruiterDto);
    }

    @Operation(summary = "Get a recruiter by company name", description = "Handles GET requests to retrieve a recruiter profile by company name.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Recruiter profile found"),
            @ApiResponse(responseCode = "404", description = "Recruiter not found")
    })
    @GetMapping("/company/{companyName}")
    public ResponseEntity<RecruiterDto> getRecruiterByCompanyName(@PathVariable String companyName) {
        RecruiterDto recruiterDto = recruiterService.getRecruiterByCompanyName(companyName);
        return ResponseEntity.ok(recruiterDto);
    }

    @Operation(summary = "Search recruiters by company name", description = "Handles GET requests to retrieve recruiters whose company name contains a specific string.")
    @ApiResponse(responseCode = "200", description = "List of recruiters with the specified company name")
    @GetMapping("/search")
    public ResponseEntity<List<RecruiterDto>> getRecruitersByCompanyNameContaining(@RequestParam String companyName) {
        List<RecruiterDto> recruiters = recruiterService.getRecruitersByCompanyNameContaining(companyName);
        return ResponseEntity.ok(recruiters);
    }
}
