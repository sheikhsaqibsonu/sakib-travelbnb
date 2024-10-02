package com.travelbnb.service;

import com.travelbnb.payload.ImageDto;

import java.util.List;

public interface ImageService {

    ImageDto addImage(ImageDto imageDto);
    ImageDto getImageById(Long id);
    List<ImageDto> getAllImages();
}
