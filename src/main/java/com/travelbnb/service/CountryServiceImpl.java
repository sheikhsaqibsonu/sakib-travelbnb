package com.travelbnb.service;

import com.travelbnb.entity.Country;
import com.travelbnb.payload.CountryDto;
import com.travelbnb.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public CountryDto addCountry(CountryDto countryDto) {
        Country country = new Country();
        country.setName(countryDto.getName());
        Country savedCountry = countryRepository.save(country);
        return mapToDto(savedCountry);
    }

    @Override
    public CountryDto getCountryById(Long id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found"));
        return mapToDto(country);
    }

    @Override
    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private CountryDto mapToDto(Country country) {
        CountryDto dto = new CountryDto();
        dto.setName(country.getName());
        return dto;
    }
}
