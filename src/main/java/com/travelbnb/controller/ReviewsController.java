package com.travelbnb.controller;

import com.travelbnb.payload.ReviewsDto;
import com.travelbnb.service.ReviewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewsController {

    private final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @PostMapping
    public ResponseEntity<ReviewsDto> createReview(@RequestBody ReviewsDto reviewsDto) {
        ReviewsDto createdReview = reviewsService.createReview(reviewsDto);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewsDto> getReviewById(@PathVariable Long id) {
        ReviewsDto reviewsDto = reviewsService.getReviewById(id);
        return ResponseEntity.ok(reviewsDto);
    }

    @GetMapping
    public ResponseEntity<List<ReviewsDto>> getAllReviews() {
        List<ReviewsDto> reviews = reviewsService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewsDto> updateReview(@PathVariable Long id, @RequestBody ReviewsDto reviewsDto) {
        ReviewsDto updatedReview = reviewsService.updateReview(id, reviewsDto);
        return ResponseEntity.ok(updatedReview);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewsService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
