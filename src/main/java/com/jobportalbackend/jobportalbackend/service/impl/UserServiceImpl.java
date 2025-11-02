package com.jobportalbackend.jobportalbackend.service.impl;

import com.jobportalbackend.jobportalbackend.dto.UserDto;
import com.jobportalbackend.jobportalbackend.entity.User;
import com.jobportalbackend.jobportalbackend.exception.UserNotFoundException;
import com.jobportalbackend.jobportalbackend.mapper.UserMapper;
import com.jobportalbackend.jobportalbackend.repository.UserRepository;
import com.jobportalbackend.jobportalbackend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the UserService interface.
 * Handles business logic for users.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new user.
     * Converts DTO to entity, saves, and converts back to DTO.
     * @param userDto The DTO containing user details.
     * @return The created UserDto with generated ID.
     */
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.toDto(savedUser);
    }

    /**
     * Retrieves a user by their ID.
     * @param id The ID of the user to retrieve.
     * @return The UserDto if found.
     * @throws UserNotFoundException if the user is not found.
     */
    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return UserMapper.toDto(user);
    }

    /**
     * Retrieves all users.
     * @return A list of all UserDto objects.
     */
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Updates an existing user.
     * @param id The ID of the user to update.
     * @param userDto The DTO containing updated user details.
     * @return The updated UserDto.
     * @throws UserNotFoundException if the user is not found.
     */
    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));

        // Update fields from DTO to existing entity
        existingUser.setName(userDto.getName());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setRole(userDto.getRole());
        // Password update logic might be more complex (e.g., encoding) and handled separately

        User updatedUser = userRepository.save(existingUser);
        return UserMapper.toDto(updatedUser);
    }

    /**
     * Deletes a user by their ID.
     * @param id The ID of the user to delete.
     * @throws UserNotFoundException if the user is not found.
     */
    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new UserNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    /**
     * Retrieves a user by their email address.
     * @param email The email address of the user.
     * @return The UserDto if found.
     * @throws UserNotFoundException if the user is not found.
     */
    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
        return UserMapper.toDto(user);
    }

    /**
     * Retrieves all users with a specific role.
     * @param role The role to search for.
     * @return A list of UserDto objects for the given role.
     */
    @Override
    public List<UserDto> getUsersByRole(String role) {
        List<User> users = userRepository.findByRole(role);
        return users.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves all users whose name contains a specific string (case-insensitive).
     * @param name The string to search for in user names.
     * @return A list of UserDto objects matching the name criteria.
     */
    @Override
    public List<UserDto> getUsersByNameContaining(String name) {
        List<User> users = userRepository.findByNameContainingIgnoreCase(name);
        return users.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }
}
