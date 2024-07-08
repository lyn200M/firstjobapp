package com.lyn.firstjobapp.companies;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lyn.firstjobapp.job.Job;
import com.lyn.firstjobapp.reviews.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String companyAddress;
    private String companyFields;
    private Long companySiren;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;


    public Company() {
    }

    public Company(Long id, String companyName, String companyAddress, String companyFields, Long companySiren, List<Job> jobs, List<Review> reviews) {
        this.id = id;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.companyFields = companyFields;
        this.companySiren = companySiren;
        this.jobs = jobs;
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyFields() {
        return companyFields;
    }

    public void setCompanyFields(String companyFields) {
        this.companyFields = companyFields;
    }

    public Long getCompanySiren() {
        return companySiren;
    }

    public void setCompanySiren(Long companySiren) {
        this.companySiren = companySiren;
    }

    public void update(Company updateCompany) {
        this.companyName = updateCompany.companyName;
        this.companyAddress = updateCompany.companyAddress;
        this.companyFields = updateCompany.companyFields;
        this.companySiren = updateCompany.companySiren;
        this.jobs = updateCompany.jobs;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
