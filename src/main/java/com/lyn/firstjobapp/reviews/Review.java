package com.lyn.firstjobapp.reviews;

import com.lyn.firstjobapp.companies.Company;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Date createdDate;
    private Date lastModification;
    private String author;
    @ManyToOne
    private Company company;

    public Review() {
    }

    public Review(Long id, String text, Date createdDate, Date lastModification, String author, Company company) {
        this.id = id;
        this.text = text;
        this.createdDate = createdDate;
        this.lastModification = lastModification;
        this.author = author;
        this.company = company;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModification() {
        return lastModification;
    }

    public void setLastModification(Date lastModification) {
        this.lastModification = lastModification;
    }

    public void update(Review updateReview) {
        this.text = text;
        this.lastModification = updateReview.lastModification;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}
