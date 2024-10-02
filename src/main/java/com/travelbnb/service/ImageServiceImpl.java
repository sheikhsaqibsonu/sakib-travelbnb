package com.travelbnb.service;

import com.travelbnb.entity.Image;
import com.travelbnb.payload.ImageDto;
import com.travelbnb.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public ImageDto addImage(ImageDto imageDto) {
        Image image = new Image();
        image.setImageUrl(imageDto.getImageUrl());
        image.setProperty(imageDto.getProperty());
        Image savedImage = imageRepository.save(image);
        return mapToDto(savedImage);
    }

    @Override
    public ImageDto getImageById(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        return mapToDto(image);
    }

    @Override
    public List<ImageDto> getAllImages() {
        return imageRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private ImageDto mapToDto(Image image) {
        ImageDto dto = new ImageDto();
        dto.setImageUrl(image.getImageUrl());
        dto.setProperty(image.getProperty());
        return dto;
    }
}

