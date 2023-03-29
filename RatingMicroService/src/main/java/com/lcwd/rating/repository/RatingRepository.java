package com.lcwd.rating.repository;

import com.lcwd.rating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long>{
    List<Rating>findAllByUserId(Long userId);
    List<Rating>findAllByHotelId(String hotelId);

}
