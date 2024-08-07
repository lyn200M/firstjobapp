package com.lyn.firstjobapp.companies;

import java.util.List;

public interface ICompaniesService {
    List<Company> findAllCompanies();

    Company findCompanyById(Long id);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    boolean updateCompany(Long id, Company updateCompany);
}
