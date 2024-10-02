package com.travelbnb.service;

import com.travelbnb.payload.FavouriteDto;

import java.util.List;

public interface FavouriteService {

        FavouriteDto addFavourite(FavouriteDto favouriteDto);
        FavouriteDto getFavouriteById(Long id);
        List<FavouriteDto> getAllFavourites();
    }
