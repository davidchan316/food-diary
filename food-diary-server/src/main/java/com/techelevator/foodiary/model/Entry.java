package com.techelevator.foodiary.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Entry {

    private int entryId;
    @NotBlank(message = "The field 'entryName' is required.")
    private String entryName;
    private int locationId;
    private int restaurantId;
    @NotNull(message = "The field 'dateTime' is required.")
    private LocalDateTime dateTime;
    private String description;
    @Min(value = 0, message = "The price must be greater than $0.00.")
    private BigDecimal price;
    @Min(value = 0, message = "The minimum rating is 0.")
    @Max(value = 5, message = "The maximum rating is 5.")
    private BigDecimal rating;

    public Entry() {

    }

    public Entry(int entryId, String entryName, int locationId, int restaurantId, LocalDateTime dateTime, String description, BigDecimal price, BigDecimal rating) {
        this.entryId = entryId;
        this.entryName = entryName;
        this.locationId = locationId;
        this.restaurantId = restaurantId;
        this.dateTime = dateTime;
        this.description = description;
        this.price = price;
        this.rating = rating;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return entryId == entry.entryId && locationId == entry.locationId && restaurantId == entry.restaurantId && Objects.equals(entryName, entry.entryName) && Objects.equals(dateTime, entry.dateTime) && Objects.equals(description, entry.description) && Objects.equals(price, entry.price) && Objects.equals(rating, entry.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entryId, entryName, locationId, restaurantId, dateTime, description, price, rating);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "entryId=" + entryId +
                ", entryName='" + entryName + '\'' +
                ", locationId=" + locationId +
                ", restaurantId=" + restaurantId +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }

}
