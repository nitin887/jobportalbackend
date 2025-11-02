package com.jobportalbackend.jobportalbackend.repository;

import com.jobportalbackend.jobportalbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByRole(String role);
    List<User> findByNameContainingIgnoreCase(String name);
    List<User> findByEmailContainingIgnoreCase(String email);
    List<User> findByNameAndEmail(String name, String email);
    Optional<User> findByName(String name);

}
