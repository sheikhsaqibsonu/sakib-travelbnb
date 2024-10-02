package com.travelbnb.controller;

import com.travelbnb.payload.AppUserDto;
import com.travelbnb.repository.AppUserRepository;
import com.travelbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final AppUserRepository appUserRepository;

    @Autowired
    public UserController(UserService userService, AppUserRepository appUserRepository) {
        this.userService = userService;
        this.appUserRepository = appUserRepository;
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody AppUserDto dto) {
        if (appUserRepository.existsByEmail(dto.getEmail())) {
            return new ResponseEntity<>("Email Exists", HttpStatus.BAD_REQUEST);
        }
        if (appUserRepository.existsByUsername(dto.getUsername())) {
            return new ResponseEntity<>("Username Exists", HttpStatus.BAD_REQUEST);
        }

        AppUserDto createdUser = userService.createUser(dto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AppUserDto>> getAllUsers(
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        List<AppUserDto> users = userService.getAllUsers(pageSize, pageNo, sortBy, sortDir);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserDto> getUserById(@PathVariable long id) {
        AppUserDto user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUserDto> updateUser(@PathVariable long id, @RequestBody AppUserDto dto) {
        AppUserDto updatedUser = userService.updateUser(id, dto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}

