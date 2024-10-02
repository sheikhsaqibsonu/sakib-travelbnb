package com.travelbnb.service;

import com.travelbnb.payload.LocationDto;

import java.util.List;

public interface LocationService {

    LocationDto addLocation(LocationDto locationDto);
    LocationDto getLocationById(Long id);
    List<LocationDto> getAllLocations();
}
