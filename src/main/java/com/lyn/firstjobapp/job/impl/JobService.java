package com.lyn.firstjobapp.job.impl;

import com.lyn.firstjobapp.job.IJobService;
import com.lyn.firstjobapp.job.Job;
import com.lyn.firstjobapp.job.IJobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService implements IJobService {
    IJobRepository jobRepository;

    public JobService(IJobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAllJob() {

        return (jobRepository.findAll());
    }
    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job findJobById(Long id) {
        return (jobRepository.findById(id).orElse(null));
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return (false);
        }
    }

    @Override
    public boolean putJobById(Long id, Job updateJob) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job job = optionalJob.get();
            job.update(updateJob);
            jobRepository.save(job);
            return (true);
        }
        return (false);
    }
}
