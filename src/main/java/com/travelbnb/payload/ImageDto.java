package com.travelbnb.payload;

import com.travelbnb.entity.Property;

public class ImageDto {

    private Long id;
    private String imageUrl;
    private Property property;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}




