package com.travelbnb.service;

import com.travelbnb.entity.AppUser;
import com.travelbnb.payload.AppUserDto;
import com.travelbnb.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUserDto createUser(AppUserDto dto) {
        AppUser user = new AppUser();
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // This is the encoded password

        // Save user to the database
        AppUser savedUser = appUserRepository.save(user);

        return convertToDto(savedUser);
    }

    @Override
    public void deleteUser(long userId) {
        appUserRepository.deleteById(userId);
    }

    @Override
    public List<AppUserDto> getAllUsers(int pageSize, int pageNo, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Page<AppUser> userPage = appUserRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        return userPage.getContent().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDto updateUser(long userId, AppUserDto dto) {
        AppUser user = appUserRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // Ensure this is encoded

        AppUser updatedUser = appUserRepository.save(user);
        return convertToDto(updatedUser);
    }

    @Override
    public AppUserDto getUserById(long userId) {
        AppUser user = appUserRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return convertToDto(user);
    }

    private AppUserDto convertToDto(AppUser user) {
        AppUserDto dto = new AppUserDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        // Don't expose the password in the DTO
        return dto;
    }
}
