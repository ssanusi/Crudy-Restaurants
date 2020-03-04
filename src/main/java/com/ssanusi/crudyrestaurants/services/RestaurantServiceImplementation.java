package com.ssanusi.crudyrestaurants.services;

import com.ssanusi.crudyrestaurants.models.Menu;
import com.ssanusi.crudyrestaurants.models.Restaurant;
import com.ssanusi.crudyrestaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "restaurantService")
public class RestaurantServiceImplementation implements RestaurantService {

    @Autowired
    private RestaurantRepository restrepos;

    @Override
    public List<Restaurant> findall() {
        List<Restaurant> restList = new ArrayList<>();
        restrepos.findAll().iterator().forEachRemaining(restList::add);
        return restList;
    }

    @Override
    public Restaurant findById(long id) {
        return restrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Not Found " + id));
    }

    @Transactional
    @Override
    public Restaurant save(Restaurant restaurant) {
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setName(restaurant.getName());
        newRestaurant.setAddress(restaurant.getAddress());
        newRestaurant.setCity(restaurant.getCity());
        newRestaurant.setState(restaurant.getState());
        newRestaurant.setTelephone(restaurant.getTelephone());

        for (Menu m : restaurant.getMenus()) {
            newRestaurant.getMenus().add(new Menu(m.getDish(), m.getPrice(), newRestaurant));
        }
        return restrepos.save(newRestaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant, long id) {

        return restrepos.save(restaurant);
    }

    @Override
    public void delete(long id) {

        restrepos.deleteById(id);
    }
}
