package com.travelbnb.payload;

import com.travelbnb.entity.Property;

public class RoomDto {

    private Long id;
    private Integer roomNumber;
    private Boolean status = false;
    private Property property;


    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}