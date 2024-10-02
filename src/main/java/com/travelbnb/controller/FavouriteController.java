package com.travelbnb.controller;

import com.travelbnb.payload.FavouriteDto;
import com.travelbnb.service.FavouriteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favourites")
public class FavouriteController {

    private final FavouriteService favouriteService;

    public FavouriteController(FavouriteService favouriteService) {
        this.favouriteService = favouriteService;
    }

    @PostMapping
    public ResponseEntity<FavouriteDto> addFavourite(@RequestBody FavouriteDto favouriteDto) {
        return ResponseEntity.ok(favouriteService.addFavourite(favouriteDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavouriteDto> getFavouriteById(@PathVariable Long id) {
        return ResponseEntity.ok(favouriteService.getFavouriteById(id));
    }

    @GetMapping
    public ResponseEntity<List<FavouriteDto>> getAllFavourites() {
        return ResponseEntity.ok(favouriteService.getAllFavourites());
    }
}

