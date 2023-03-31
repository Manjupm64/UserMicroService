package com.lcwd.hotel.controller;

import com.lcwd.hotel.entity.Hotel;
import com.lcwd.hotel.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
@AllArgsConstructor
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Hotel> saveHotelDetails(@RequestBody Hotel hotel){
        Hotel savedHotelDtls = hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotelDtls);
    }

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping
    public  ResponseEntity<List<Hotel>> getAllHoteldtls(){
        List<Hotel> hotelList = hotelService.getAllHotels();
        return ResponseEntity.ok(hotelList);
    }


    @PreAuthorize("hasAuthority('SCOPE_internal')")
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
        Hotel hotelDtls= hotelService.getHotelById(id);
        return ResponseEntity.ok(hotelDtls);
    }
}
