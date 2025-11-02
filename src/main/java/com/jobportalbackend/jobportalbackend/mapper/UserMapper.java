package com.jobportalbackend.jobportalbackend.mapper;

import com.jobportalbackend.jobportalbackend.dto.UserDto;
import com.jobportalbackend.jobportalbackend.entity.User;

public class UserMapper {

    public static UserDto toDto(User user) {
        if (user == null) {
            return null;
        }

        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }

    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        // Note: Password is not mapped from DTO to entity for security reasons.
        // It should be handled separately in the service layer (e.g., encoding).
        return user;
    }
}
