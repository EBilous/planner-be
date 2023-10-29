package com.plannerbe.domain.mapper;

import com.plannerbe.domain.dto.AddressDTO;
import com.plannerbe.domain.dto.UserDTO;
import com.plannerbe.domain.entity.User;
import com.plannerbe.domain.repository.AddressRepository;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(@NotNull User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setLastName(user.getLastName());
        dto.setFirstName(user.getFirstName());
        dto.setPassword(user.getPassword());
        dto.setPhone(user.getPhone());
        dto.setAddress(AddressDTO.builder().build());
        return dto;
    }

    public User toEntity(@NotNull UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setLastName(userDTO.getLastName());
        user.setFirstName(userDTO.getFirstName());
        user.setPassword(userDTO.getPassword());
        user.setPhone(user.getPhone());
        user.setAddress(user.getAddress());
        return user;
    }
}
