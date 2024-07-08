package com.lyn.firstjobapp.job;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IJobService {
    public List<Job> findAllJob();
    public void createJob(Job job);

    public Job findJobById(Long id);

    boolean deleteJobById(Long id);

    boolean putJobById(Long id, Job updateJob);
}
