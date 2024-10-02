package com.travelbnb.service;

import com.travelbnb.payload.PropertyDto;

import java.util.List;

public interface PropertyService {

    PropertyDto createProperty(PropertyDto propertyDto);
    PropertyDto getPropertyById(Long id);
    List<PropertyDto> getAllProperties();
    PropertyDto updateProperty(Long id, PropertyDto propertyDto);
    void deleteProperty(Long id);
}
