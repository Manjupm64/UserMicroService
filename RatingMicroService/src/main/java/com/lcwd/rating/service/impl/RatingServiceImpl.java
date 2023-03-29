package com.lcwd.rating.service.impl;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.exception.ResourceNotFoundException;
import com.lcwd.rating.repository.RatingRepository;
import com.lcwd.rating.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveRatingDtls(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating gatRatingsById(Long id) {
        return ratingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Ratings With give  Id  is not found on server !!"+ id));
    }

    @Override
    public List<Rating> getAllRatingsByUserId(Long userId) {
        return ratingRepository.findAllByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingSByHotelId(String hotelId) {
        return ratingRepository.findAllByHotelId(hotelId);
    }
}
