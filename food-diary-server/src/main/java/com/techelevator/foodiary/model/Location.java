package com.techelevator.foodiary.model;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class Location {

    private int locationId;
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

    public Location() {

    }

    public Location(int locationId, String address, String city, String state, String postalCode, String country) {
        this.locationId = locationId;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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
        Location location = (Location) o;
        return locationId == location.locationId && Objects.equals(address, location.address) && Objects.equals(city, location.city) && Objects.equals(state, location.state) && Objects.equals(postalCode, location.postalCode) && Objects.equals(country, location.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, address, city, state, postalCode, country);
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

}
