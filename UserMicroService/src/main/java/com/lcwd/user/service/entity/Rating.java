package com.lcwd.user.service.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private Long ratingId;
    private Long userId;
    private String hotelId;

    private String rating;

    private String feedback;

    private Hotel hotel;
}
