package com.lyn.firstjobapp.reviews;

import java.util.List;

public interface IReviewsService {
    List<Review> findAllReviews(Long companyId);
    Review findReviewById(Long companyId, Long reviewId);
    boolean createReview(Long companyId, Review review);
    boolean updateReview(Long companyId, Long reviewId, Review updateReview);
    boolean deleteReviewById(Long companyId, Long reviewId);
}
