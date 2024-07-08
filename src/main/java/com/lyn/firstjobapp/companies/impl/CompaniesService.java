package com.lyn.firstjobapp.companies.impl;

import com.lyn.firstjobapp.companies.Company;
import com.lyn.firstjobapp.companies.ICompaniesRepository;
import com.lyn.firstjobapp.companies.ICompaniesService;
import com.lyn.firstjobapp.job.IJobRepository;
import com.lyn.firstjobapp.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniesService implements ICompaniesService {
    ICompaniesRepository companiesRepository;
    IJobRepository jobRepository;

    public CompaniesService(ICompaniesRepository companiesRepository, IJobRepository jobRepository) {
        this.companiesRepository = companiesRepository;
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Company> findAllCompanies() {
        return (companiesRepository.findAll());
    }

    @Override
    public Company findCompanyById(Long id) {
        return (companiesRepository.findById(id).orElse(null));
    }

    @Override
    public void createCompany(Company company) {
        companiesRepository.save(company);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        try {
            Company deleteCompany = companiesRepository.getReferenceById(id);
            List<Job> linkJobs = deleteCompany.getJobs();
            for (Job job : linkJobs) {
                jobRepository.deleteById(job.getId());
            }
            companiesRepository.deleteById(id);
            return (true);
        } catch (Exception e) {
            return (false);
        }
    }
    @Override
    public boolean updateCompany(Long id, Company updateCompany) {
        Optional<Company> optionalCompany = companiesRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company.update(updateCompany);
            companiesRepository.save(company);
            return (true);
        }
        return false;
    }
}
