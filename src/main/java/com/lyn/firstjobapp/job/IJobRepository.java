package com.lyn.firstjobapp.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobRepository extends JpaRepository<Job, Long> {
}
