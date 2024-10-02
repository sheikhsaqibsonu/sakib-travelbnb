package com.travelbnb.service;

import com.travelbnb.payload.AppUserDto;

import java.util.List;

public interface UserService {
    AppUserDto createUser(AppUserDto dto);
    void deleteUser(long userId);
    List<AppUserDto> getAllUsers(int pageSize, int pageNo, String sortBy, String sortDir);
    AppUserDto updateUser(long userId, AppUserDto dto);
    AppUserDto getUserById(long userId);

}
