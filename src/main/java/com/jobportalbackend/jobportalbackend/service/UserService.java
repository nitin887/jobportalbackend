package com.jobportalbackend.jobportalbackend.service;

import com.jobportalbackend.jobportalbackend.dto.UserDto;

import java.util.List;

/**
 * Service interface for managing users.
 * Defines CRUD operations and custom queries for users.
 */
public interface UserService {

    /**
     * Creates a new user.
     * @param userDto The DTO containing user details.
     * @return The created UserDto with generated ID.
     */
    UserDto createUser(UserDto userDto);

    /**
     * Retrieves a user by their ID.
     * @param id The ID of the user to retrieve.
     * @return The UserDto if found.
     */
    UserDto getUserById(Long id);

    /**
     * Retrieves all users.
     * @return A list of all UserDto objects.
     */
    List<UserDto> getAllUsers();

    /**
     * Updates an existing user.
     * @param id The ID of the user to update.
     * @param userDto The DTO containing updated user details.
     * @return The updated UserDto.
     */
    UserDto updateUser(Long id, UserDto userDto);

    /**
     * Deletes a user by their ID.
     * @param id The ID of the user to delete.
     */
    void deleteUser(Long id);

    /**
     * Retrieves a user by their email address.
     * @param email The email address of the user.
     * @return The UserDto if found.
     */
    UserDto getUserByEmail(String email);

    /**
     * Retrieves all users with a specific role.
     * @param role The role to search for.
     * @return A list of UserDto objects for the given role.
     */
    List<UserDto> getUsersByRole(String role);

    /**
     * Retrieves all users whose name contains a specific string (case-insensitive).
     * @param name The string to search for in user names.
     * @return A list of UserDto objects matching the name criteria.
     */
    List<UserDto> getUsersByNameContaining(String name);
}
