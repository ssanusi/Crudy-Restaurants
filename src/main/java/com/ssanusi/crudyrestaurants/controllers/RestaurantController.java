package com.ssanusi.crudyrestaurants.controllers;

import com.ssanusi.crudyrestaurants.models.Restaurant;
import com.ssanusi.crudyrestaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(value = "", produces = {"application/json"})
    public ResponseEntity<?> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.findall();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @GetMapping(value = "/{restaurantid}", produces = {"application/json"})
    public ResponseEntity<?> findById(@PathVariable long restaurantid) {
        Restaurant restaurant = restaurantService.findById(restaurantid);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PostMapping(value = "", consumes = {"application/json"})
    public ResponseEntity<?> addNewRestaurant(@Valid @RequestBody Restaurant newRestaurant) {
        restaurantService.save(newRestaurant);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{restaurantid}", consumes = {"application/json"})
    public ResponseEntity<?> updateRestaurant(@RequestBody Restaurant restaurant, @PathVariable long restaurantid) {
        restaurantService.update(restaurant, restaurantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{restaurantid}")
    public ResponseEntity<?> deleteRestaurantById(@PathVariable long restaurantid) {
        restaurantService.delete(restaurantid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
