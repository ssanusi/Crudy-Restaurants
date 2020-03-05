package com.ssanusi.crudyrestaurants;

import com.ssanusi.crudyrestaurants.models.Menu;
import com.ssanusi.crudyrestaurants.models.Restaurant;
import com.ssanusi.crudyrestaurants.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    RestaurantService restaurantService;

    @Override
    public void run(String[] args) throws Exception {

        String rest1Name = "Apple Cafe";
        Restaurant r1 = new Restaurant(rest1Name, "123 Least Street", "Minna", "NG", "555-555-1234");
        r1.getMenus().add(new Menu("Mac and Cheese", 5.95, r1));
        restaurantService.save(r1);

        String rest2Name = "Chicken Republic";
        Restaurant r2 = new Restaurant(rest2Name, "456 Least Street", "Kaduna", "KD", "555-555-1234");
        r2.getMenus().add(new Menu("Mac and Cheese", 8.95, r2));
        restaurantService.save(r2);


        String rest3Name = "Jade Palace Chinese Cuisine";
        Restaurant r3 = new Restaurant(rest3Name, "678 Least Street", "Kano", "KN", "555-555-1234");
        r3.getMenus().add(new Menu("Mac and Cheese", 10.95, r3));
        restaurantService.save(r3);


        List<Restaurant> printList = restaurantService.findall();
        System.out.println("\n********************* SEED DATA ***********************");
        for (Restaurant r : printList)
            System.out.println(r);
        System.out.println("\n********************* SEED DATA ***********************");


    }
}