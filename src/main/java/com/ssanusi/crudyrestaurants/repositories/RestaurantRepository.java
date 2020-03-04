package com.ssanusi.crudyrestaurants.repositories;

import com.ssanusi.crudyrestaurants.models.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}
