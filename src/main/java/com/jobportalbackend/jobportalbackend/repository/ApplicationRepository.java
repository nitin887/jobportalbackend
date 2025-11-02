package com.jobportalbackend.jobportalbackend.repository;

import com.jobportalbackend.jobportalbackend.entity.Application;
import com.jobportalbackend.jobportalbackend.entity.ApplicationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findByUserId(Long userId);
    List<Application> findByJobId(Long jobId);
    List<Application> findByApplicationEnum(ApplicationEnum status);
    Optional<Application> findByUserIdAndJobId(Long userId, Long jobId);
    List<Application> findByUserIdAndApplicationEnum(Long userId, ApplicationEnum status);

}
