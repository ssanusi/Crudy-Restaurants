package com.ssanusi.crudyrestaurants.services;

import com.ssanusi.crudyrestaurants.models.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> findall();

    Restaurant findById(long id);

    Restaurant save(Restaurant restaurant);

    Restaurant update(Restaurant restaurant, long id);

    void delete(long id);
}
