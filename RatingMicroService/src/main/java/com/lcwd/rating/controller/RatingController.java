package com.lcwd.rating.controller;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@AllArgsConstructor
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> savaRatingDtls(@RequestBody Rating rating){
        Rating savedRatingDtls = ratingService.saveRatingDtls(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(rating);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> getRatingById(@PathVariable Long id){
        Rating ratingDtlsById = ratingService.gatRatingsById(id);
        return ResponseEntity.ok(ratingDtlsById);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatingDtls(){
        List<Rating> listOfRatings = ratingService.getAllRatings();
        return ResponseEntity.ok(listOfRatings);
    }

    @GetMapping("/user/{user-id}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable("user-id") Long userId){
        List<Rating> ratingAllDtlsByUserId = ratingService.getAllRatingsByUserId(userId);
        return ResponseEntity.ok(ratingAllDtlsByUserId);
    }

    @GetMapping("/hotel/{hotel-id}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable("hotel-id") String hotelId){
        List<Rating> ratingAllDtlsByHotelId = ratingService.getAllRatingSByHotelId(hotelId);
        return ResponseEntity.ok(ratingAllDtlsByHotelId);
    }


}
