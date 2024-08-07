package com.lyn.firstjobapp.reviews;

import com.lyn.firstjobapp.companies.Company;
import com.lyn.firstjobapp.companies.ICompaniesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsService implements IReviewsService{
    private final IReviewRepository reviewRepository;
    private final ICompaniesService companiesService;

    public ReviewsService(IReviewRepository reviewRepository, ICompaniesService companiesService) {
        this.reviewRepository = reviewRepository;
        this.companiesService = companiesService;
    }


    @Override
    public List<Review> findAllReviews(Long companyId) {
        return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public Review findReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return (reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null));
    }

    @Override
    public boolean createReview(Long companyId, Review review) {
        Company company = companiesService.findCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return (true);
        }
        return (false);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updateReview) {
        Company company = companiesService.findCompanyById(companyId);
        if (company != null) {
            updateReview.setCompany(company);
            updateReview.setId(reviewId);
            reviewRepository.save(updateReview);
            return (true);
        }
        return false;
    }

    @Override
    public boolean deleteReviewById(Long companyId, Long reviewId) {
        if (companiesService.findCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
            Review review = reviewRepository.getReferenceById(reviewId);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companiesService.updateCompany(companyId, company);
            reviewRepository.deleteById(reviewId);
            return (true);
        }
        return false;
    }
}
