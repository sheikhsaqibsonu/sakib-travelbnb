package com.travelbnb.service.impl;

import com.travelbnb.payload.PropertyDto;
import com.travelbnb.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final List<PropertyDto> propertyList = new ArrayList<>();

    @Override
    public PropertyDto createProperty(PropertyDto propertyDto) {
        propertyDto.setId((long) (propertyList.size() + 1)); // Simple ID generation
        propertyList.add(propertyDto);
        return propertyDto;
    }

    @Override
    public PropertyDto getPropertyById(Long id) {
        return propertyList.stream()
                .filter(property -> property.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<PropertyDto> getAllProperties() {
        return new ArrayList<>(propertyList);
    }

    @Override
    public PropertyDto updateProperty(Long id, PropertyDto propertyDto) {
        PropertyDto existingProperty = getPropertyById(id);
        if (existingProperty != null) {
            existingProperty.setName(propertyDto.getName());
            existingProperty.setNoGuests(propertyDto.getNoGuests());
            existingProperty.setNoBedrooms(propertyDto.getNoBedrooms());
            existingProperty.setNoBathrooms(propertyDto.getNoBathrooms());
            existingProperty.setNightlyPrice(propertyDto.getNightlyPrice());
            existingProperty.setLocation(propertyDto.getLocation());
            existingProperty.setCountry(propertyDto.getCountry());
        }
        return existingProperty;
    }

    @Override
    public void deleteProperty(Long id) {
        propertyList.removeIf(property -> property.getId().equals(id));
    }
}
