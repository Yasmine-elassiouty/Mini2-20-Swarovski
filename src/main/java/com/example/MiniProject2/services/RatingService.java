package com.example.MiniProject2.services;

import com.example.MiniProject2.models.Rating;
import com.example.MiniProject2.repositories.RatingRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    /** Add a new rating, after validating its score. */
    public Rating addRating(Rating rating) {
        validateScore(rating.getScore());
        return ratingRepository.save(rating);
    }

    /**
     * Update only score/comment of an existing rating.
     * Throws EntityNotFoundException if the rating doesn't exist.
     */
    public Rating updateRating(String id, Rating updated) {
        Rating existing = ratingRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rating not found: " + id));

        // Only overwrite fields if they're provided
        if (updated.getScore() != null) {
            validateScore(updated.getScore());
            existing.setScore(updated.getScore());
        }
        if (updated.getComment() != null) {
            existing.setComment(updated.getComment());
        }

        return ratingRepository.save(existing);
    }

    /**
     * Delete a rating by ID.
     * Throws EntityNotFoundException if the rating doesn't exist.
     */
    public void deleteRating(String id) {
        if (!ratingRepository.existsById(id)) {
            throw new EntityNotFoundException("Rating not found: " + id);
        }
        ratingRepository.deleteById(id);
    }

    /** Retrieve all ratings for a given entity ID + type. */
    public List<Rating> getRatingsByEntity(Long entityId, String entityType) {
        return ratingRepository.findByEntityIdAndEntityType(entityId, entityType);
    }

    /** Retrieve all ratings whose score is strictly greater than minScore. */
    public List<Rating> findRatingsAboveScore(int minScore) {
        return ratingRepository.findByScoreGreaterThan(minScore);
    }

    /** Ensures score is between 1 and 5 inclusive. */
    private void validateScore(Integer score) {
        if (score == null || score < 1 || score > 5) {
            throw new IllegalArgumentException("Score must be between 1 and 5");
        }
    }
}
