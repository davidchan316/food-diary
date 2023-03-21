package com.techelevator.foodiary.dao;

import com.techelevator.foodiary.model.Restaurant;

import java.util.List;

public interface RestaurantDao {

    List<Restaurant> listAllRestaurants();

    Restaurant getRestaurantByRestaurantId(int restaurantId);

    Restaurant createRestaurant(Restaurant newRestaurant);

    Restaurant updateRestaurant(Restaurant updateRestaurant, int restaurantId);

    void deleteRestaurant(int restaurantId);

}
