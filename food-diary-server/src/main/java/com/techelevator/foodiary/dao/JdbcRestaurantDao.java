package com.techelevator.foodiary.dao;

import com.techelevator.foodiary.model.Restaurant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRestaurantDao implements RestaurantDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcRestaurantDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Restaurant> listAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT restaurant_id, restaurant_name, address, city, state, postal_code, country FROM restaurant";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while (results.next()) {
            Restaurant restaurant = mapRowToRestaurant(results);
            restaurants.add(restaurant);
        }

        return restaurants;
    }

    @Override
    public Restaurant getRestaurantByRestaurantId(int restaurantId) {
        String sql = "SELECT restaurant_id, restaurant_name, address, city, state, postal_code, country FROM restaurant WHERE restaurant_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, restaurantId);

        if (result.next()) {
            return mapRowToRestaurant(result);
        } else {
            return null;
        }
    }

    @Override
    public Restaurant createRestaurant(Restaurant newRestaurant) {
        String sql = "INSERT INTO restaurant (restaurant_name, address, city, state, postal_code, country) VALUES (?, ?, ?, ?, ?,?) RETURNING restaurant_id;";

        Integer newRestaurantId = jdbcTemplate.queryForObject(sql, Integer.class, newRestaurant.getRestaurantName(), newRestaurant.getAddress(),
                newRestaurant.getCity(), newRestaurant.getState(), newRestaurant.getPostalCode(), newRestaurant.getCountry());
        newRestaurant.setRestaurantId(newRestaurantId);

        return newRestaurant;
    }

    @Override
    public Restaurant updateRestaurant(Restaurant updateRestaurant, int restaurantId) {
        return null;
    }

    @Override
    public void deleteRestaurant(int restaurantId) {

    }

    private Restaurant mapRowToRestaurant(SqlRowSet rowSet) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(rowSet.getInt("restaurant_id"));
        restaurant.setRestaurantName(rowSet.getString("restaurant_name"));
        restaurant.setAddress(rowSet.getString("address"));
        restaurant.setCity(rowSet.getString("city"));
        restaurant.setState(rowSet.getString("state"));
        restaurant.setPostalCode(rowSet.getString("postal_code"));
        restaurant.setCountry(rowSet.getString("country"));
        return restaurant;
    }
}
