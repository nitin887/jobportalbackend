package com.jobportalbackend.jobportalbackend.mapper;

import com.jobportalbackend.jobportalbackend.dto.JobDto;
import com.jobportalbackend.jobportalbackend.entity.Job;

import java.util.stream.Collectors;

public class JobMapper {
    public static JobDto toJobDto(Job job) {
        return new JobDto(
                job.getId(),
                job.getTile(),
                job.getDescription(),
                job.getLocation(),
                job.getSalary(),
                job.getRecruiter().stream().map(RecruiterMapper::toDto).collect(Collectors.toList()),
                job.getCreated_at()
        );
    }
    public static  Job toJobEntity(JobDto jobDto){
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setTile(jobDto.getTile());
        job.setDescription(jobDto.getDescription());
        job.setLocation(jobDto.getLocation());
        job.setSalary(jobDto.getSalary());
        job.setCreated_at(jobDto.getCreated_at());
        return job;
    }
}
