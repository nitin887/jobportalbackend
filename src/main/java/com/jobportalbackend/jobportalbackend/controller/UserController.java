package com.jobportalbackend.jobportalbackend.controller;

import com.jobportalbackend.jobportalbackend.dto.UserDto;
import com.jobportalbackend.jobportalbackend.service.UserService;
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
@RequestMapping("/api/users")
@Tag(name = "User Controller", description = "APIs for managing users")
@SecurityRequirement(name = "bearerAuth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Create a new user", description = "Handles POST requests to create a new user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a user by ID", description = "Handles GET requests to retrieve a user by their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @Operation(summary = "Get all users", description = "Handles GET requests to retrieve all users.")
    @ApiResponse(responseCode = "200", description = "List of all users")
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Update a user", description = "Handles PUT requests to update an existing user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @Operation(summary = "Delete a user", description = "Handles DELETE requests to delete a user by their ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get a user by email", description = "Handles GET requests to retrieve a user by their email address.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        UserDto userDto = userService.getUserByEmail(email);
        return ResponseEntity.ok(userDto);
    }

    @Operation(summary = "Get users by role", description = "Handles GET requests to retrieve users by role.")
    @ApiResponse(responseCode = "200", description = "List of users with the specified role")
    @GetMapping("/role/{role}")
    public ResponseEntity<List<UserDto>> getUsersByRole(@PathVariable String role) {
        List<UserDto> users = userService.getUsersByRole(role);
        return ResponseEntity.ok(users);
    }

    @Operation(summary = "Search users by name", description = "Handles GET requests to retrieve users whose name contains a specific string.")
    @ApiResponse(responseCode = "200", description = "List of users with the specified name")
    @GetMapping("/search")
    public ResponseEntity<List<UserDto>> getUsersByNameContaining(@RequestParam String name) {
        List<UserDto> users = userService.getUsersByNameContaining(name);
        return ResponseEntity.ok(users);
    }
}