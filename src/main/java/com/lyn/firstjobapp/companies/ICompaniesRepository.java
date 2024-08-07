package com.lyn.firstjobapp.companies;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompaniesRepository extends JpaRepository<Company, Long> {
}
