package com.techelevator.foodiary.service;

import com.techelevator.foodiary.dao.RestaurantDao;
import com.techelevator.foodiary.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private RestaurantDao restaurantDao;

    public RestaurantService(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public List<Restaurant> listAllRestaurants() {
        return restaurantDao.listAllRestaurants();
    }

}
