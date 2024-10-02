package com.travelbnb.service;

import com.travelbnb.payload.CountryDto;

import java.util.List;

public interface CountryService {

    CountryDto addCountry(CountryDto countryDto);
    CountryDto getCountryById(Long id);
    List<CountryDto> getAllCountries();
}
