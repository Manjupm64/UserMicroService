package com.lcwd.hotel.service;

import com.lcwd.hotel.entity.Hotel;

import java.util.List;

public interface HotelService {

    Hotel saveHotel(Hotel hotel);

    List<Hotel> getAllHotels();

    Hotel getHotelById(Long id);
}
