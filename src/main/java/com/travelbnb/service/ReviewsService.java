package com.travelbnb.service;

import com.travelbnb.payload.ReviewsDto;

import java.util.List;

public interface ReviewsService {
    ReviewsDto createReview(ReviewsDto reviewsDto);
    ReviewsDto getReviewById(Long id);
    List<ReviewsDto> getAllReviews();
    ReviewsDto updateReview(Long id, ReviewsDto reviewsDto);
    void deleteReview(Long id);
}
