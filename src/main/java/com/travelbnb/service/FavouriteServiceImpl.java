package com.travelbnb.service;

import com.travelbnb.entity.Favourite;
import com.travelbnb.payload.FavouriteDto;
import com.travelbnb.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Override
    public FavouriteDto addFavourite(FavouriteDto favouriteDto) {
        Favourite favourite = mapToEntity(favouriteDto);
        favourite = favouriteRepository.save(favourite);
        return mapToDto(favourite);
    }

    @Override
    public FavouriteDto getFavouriteById(Long id) {
        Favourite favourite = favouriteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favourite not found"));
        return mapToDto(favourite);
    }

    @Override
    public List<FavouriteDto> getAllFavourites() {
        return favouriteRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private FavouriteDto mapToDto(Favourite favourite) {
        FavouriteDto dto = new FavouriteDto();
        dto.setId(favourite.getId());
        dto.setStatus(favourite.getStatus());
        dto.setAppUser(favourite.getAppUser());
        dto.setProperty(favourite.getProperty());
        return dto;
    }

    private Favourite mapToEntity(FavouriteDto dto) {
        Favourite favourite = new Favourite();
        favourite.setId(dto.getId());
        favourite.setStatus(dto.getStatus());
        favourite.setAppUser(dto.getAppUser());
        favourite.setProperty(dto.getProperty());
        return favourite;
    }
}
