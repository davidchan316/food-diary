package com.techelevator.foodiary.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Restaurant {

    private int restaurantId;
    @Min(value = 1, message = "The field 'locationId' is required.")
    private int locationId;
    @NotBlank(message = "The field 'restaurantName' is required.")
    private String restaurantName;

    public Restaurant() {

    }

    public Restaurant(int restaurantId, int locationId, String restaurantName) {
        this.restaurantId = restaurantId;
        this.locationId = locationId;
        this.restaurantName = restaurantName;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return restaurantId == that.restaurantId && locationId == that.locationId && Objects.equals(restaurantName, that.restaurantName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, locationId, restaurantName);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", locationId=" + locationId +
                ", restaurantName='" + restaurantName + '\'' +
                '}';
    }

}
