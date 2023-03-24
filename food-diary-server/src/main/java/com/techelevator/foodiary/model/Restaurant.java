package com.techelevator.foodiary.model;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Restaurant {

    private int restaurantId;
    @NotBlank(message = "The field 'restaurantName' is required.")
    private String restaurantName;
    @NotBlank(message="The field 'address' is required.")
    private String address;
    @NotBlank(message="The field 'city' is required.")
    private String city;
    @NotBlank(message="The field 'state' is required.")
    private String state;
    @NotBlank(message="The field 'postalCode' is required.")
    private String postalCode;
    @NotBlank(message="The field 'country' is required.")
    private String country;

    public Restaurant() {

    }

    public Restaurant(int restaurantId, String restaurantName, String address, String city, String state, String postalCode, String country) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return restaurantId == that.restaurantId && Objects.equals(restaurantName, that.restaurantName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(postalCode, that.postalCode) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, restaurantName, address, city, state, postalCode, country);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", restaurantName='" + restaurantName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
