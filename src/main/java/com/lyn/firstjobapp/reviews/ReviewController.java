package com.lyn.firstjobapp.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/companies/{companyId}/reviews")
public class ReviewController {
    IReviewsService reviewsService;

    public ReviewController(IReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> findAllReview(@PathVariable Long companyId) {
        return (new ResponseEntity<>(HttpStatus.OK));
    }
}
