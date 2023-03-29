package com.lcwd.rating.service;

import com.lcwd.rating.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating saveRatingDtls(Rating rating);

    List<Rating> getAllRatings();

    Rating gatRatingsById(Long id);

    List<Rating> getAllRatingsByUserId(Long UserId);

    List<Rating> getAllRatingSByHotelId(String hotelId);
}
