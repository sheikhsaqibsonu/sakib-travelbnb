package com.travelbnb.service;

import com.travelbnb.entity.Location;
import com.travelbnb.payload.LocationDto;
import com.travelbnb.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public LocationDto addLocation(LocationDto locationDto) {
        Location location = new Location();
        location.setName(locationDto.getName());
        Location savedLocation = locationRepository.save(location);
        return mapToDto(savedLocation);
    }

    @Override
    public LocationDto getLocationById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Location not found"));
        return mapToDto(location);
    }

    @Override
    public List<LocationDto> getAllLocations() {
        return locationRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private LocationDto mapToDto(Location location) {
        LocationDto dto = new LocationDto();
        dto.setName(location.getName());
        return dto;
    }
}
