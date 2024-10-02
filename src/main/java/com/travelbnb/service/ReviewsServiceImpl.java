package com.travelbnb.service;

import com.travelbnb.payload.ReviewsDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    private final List<ReviewsDto> reviewList = new ArrayList<>();

    @Override
    public ReviewsDto createReview(ReviewsDto reviewsDto) {
        reviewsDto.setId((long) (reviewList.size() + 1)); // Simple ID generation
        reviewList.add(reviewsDto);
        return reviewsDto;
    }

    @Override
    public ReviewsDto getReviewById(Long id) {
        return reviewList.stream()
                .filter(review -> review.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<ReviewsDto> getAllReviews() {
        return new ArrayList<>(reviewList);
    }

    @Override
    public ReviewsDto updateReview(Long id, ReviewsDto reviewsDto) {
        ReviewsDto existingReview = getReviewById(id);
        if (existingReview != null) {
            existingReview.setRatings(reviewsDto.getRatings());
            existingReview.setDescription(reviewsDto.getDescription());
            existingReview.setAppUser(reviewsDto.getAppUser());
            existingReview.setProperty(reviewsDto.getProperty());
        }
        return existingReview;
    }

    @Override
    public void deleteReview(Long id) {
        reviewList.removeIf(review -> review.getId().equals(id));
    }
}
