package com.jobportalbackend.jobportalbackend.mapper;

import com.jobportalbackend.jobportalbackend.dto.JobSeekerDto;
import com.jobportalbackend.jobportalbackend.entity.JobSeeker;
import com.jobportalbackend.jobportalbackend.entity.User;

public class JobSeekerMapper {

    public static JobSeekerDto toDto(JobSeeker jobSeeker) {
        if (jobSeeker == null) {
            return null;
        }

        JobSeekerDto jobSeekerDto = new JobSeekerDto();
        jobSeekerDto.setId(jobSeeker.getId());
        if (jobSeeker.getUser() != null) {
            jobSeekerDto.setUserId(jobSeeker.getUser().getId());
        }
        jobSeekerDto.setResume_url(jobSeeker.getResume_url());
        jobSeekerDto.setSkills(jobSeeker.getSkills());
        jobSeekerDto.setExperience(jobSeeker.getExperience());

        return jobSeekerDto;
    }

    public static JobSeeker toEntity(JobSeekerDto jobSeekerDto) {
        if (jobSeekerDto == null) {
            return null;
        }

        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setId(jobSeekerDto.getId());
        if (jobSeekerDto.getUserId() != null) {
            User user = new User();
            user.setId(jobSeekerDto.getUserId());
            jobSeeker.setUser(user);
        }
        jobSeeker.setResume_url(jobSeekerDto.getResume_url());
        jobSeeker.setSkills(jobSeekerDto.getSkills());
        jobSeeker.setExperience(jobSeekerDto.getExperience());

        return jobSeeker;
    }
}
