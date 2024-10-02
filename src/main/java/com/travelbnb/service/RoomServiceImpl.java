package com.travelbnb.service;

import com.travelbnb.entity.Room;
import com.travelbnb.payload.RoomDto;
import com.travelbnb.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomDto createRoom(RoomDto roomDto) {
        Room room = new Room();
        // map RoomDto to Room entity
        room = roomRepository.save(room);
        return mapToDto(room);
    }

    @Override
    public RoomDto getRoomById(Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        return mapToDto(room);
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private RoomDto mapToDto(Room room) {
        RoomDto dto = new RoomDto();
        // map Room entity to RoomDto
        return dto;
    }
}
