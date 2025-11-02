package com.jobportalbackend.jobportalbackend.mapper;

import com.jobportalbackend.jobportalbackend.dto.RecruiterDto;
import com.jobportalbackend.jobportalbackend.entity.Recruiter;
import com.jobportalbackend.jobportalbackend.entity.User;

public class RecruiterMapper {

    public static RecruiterDto toDto(Recruiter recruiter) {
        if (recruiter == null) {
            return null;
        }

        RecruiterDto recruiterDto = new RecruiterDto();
        recruiterDto.setId(recruiter.getId());
        if (recruiter.getUser() != null) {
            recruiterDto.setUserId(recruiter.getUser().getId());
        }
        recruiterDto.setCompanyName(recruiter.getCompanyName());
        recruiterDto.setContact_info(recruiter.getContact_info());

        return recruiterDto;
    }

    public static Recruiter toEntity(RecruiterDto recruiterDto) {
        if (recruiterDto == null) {
            return null;
        }

        Recruiter recruiter = new Recruiter();
        recruiter.setId(recruiterDto.getId());
        if (recruiterDto.getUserId() != null) {
            User user = new User();
            user.setId(recruiterDto.getUserId());
            recruiter.setUser(user);
        }
        recruiter.setCompanyName(recruiterDto.getCompanyName());
        recruiter.setContact_info(recruiterDto.getContact_info());

        return recruiter;
    }
}
