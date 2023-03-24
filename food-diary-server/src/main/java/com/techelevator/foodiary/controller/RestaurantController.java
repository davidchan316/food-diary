package com.techelevator.foodiary.controller;

import com.techelevator.foodiary.model.Restaurant;
import com.techelevator.foodiary.service.RestaurantService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@PreAuthorize("isAuthenticated()")
public class RestaurantController {

    private RestaurantService restaurantService;

    public RestaurantController (RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    @PreAuthorize("permitAll")
    public List<Restaurant> listAllRestaurants() {
        return restaurantService.listAllRestaurants();
    }

}
