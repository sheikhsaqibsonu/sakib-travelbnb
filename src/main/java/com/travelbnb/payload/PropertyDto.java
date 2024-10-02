package com.travelbnb.payload;

import com.travelbnb.entity.Country;
import com.travelbnb.entity.Location;

public class PropertyDto {

    private Long id;
    private String name;
    private Integer noGuests;
    private Integer noBedrooms;
    private Integer noBathrooms;
    private Integer nightlyPrice;
    private Location location;
    private Country country;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getNightlyPrice() {
        return nightlyPrice;
    }

    public void setNightlyPrice(Integer nightlyPrice) {
        this.nightlyPrice = nightlyPrice;
    }

    public Integer getNoBathrooms() {
        return noBathrooms;
    }

    public void setNoBathrooms(Integer noBathrooms) {
        this.noBathrooms = noBathrooms;
    }

    public Integer getNoBedrooms() {
        return noBedrooms;
    }

    public void setNoBedrooms(Integer noBedrooms) {
        this.noBedrooms = noBedrooms;
    }

    public Integer getNoGuests() {
        return noGuests;
    }

    public void setNoGuests(Integer noGuests) {
        this.noGuests = noGuests;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
