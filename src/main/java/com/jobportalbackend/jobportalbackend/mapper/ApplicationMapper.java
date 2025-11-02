package com.jobportalbackend.jobportalbackend.mapper;

import com.jobportalbackend.jobportalbackend.dto.ApplicationDto;
import com.jobportalbackend.jobportalbackend.entity.Application;
import com.jobportalbackend.jobportalbackend.entity.Job;
import com.jobportalbackend.jobportalbackend.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class ApplicationMapper {
    public static ApplicationDto toDto(Application application){
        return new ApplicationDto(
                application.getId(),
                application.getJob().getId(),
                application.getUser().getId(),
                application.getApplicationEnum(),
                application.getApplied_at()
        );
    }
    public static Application toEntity(ApplicationDto applicationDto){
        Application application = new Application();
        application.setId(applicationDto.getId());

        Job job = new Job();
        job.setId(applicationDto.getJobId());
        application.setJob(job);

        User user = new User();
        user.setId(applicationDto.getUserId());
        application.setUser(user);

        application.setApplicationEnum(applicationDto.getApplicationEnum());
        application.setApplied_at(applicationDto.getApplied_at());
        return application;
    }

}
