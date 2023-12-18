package com.plannerbe.domain.mapper;

import com.plannerbe.domain.dto.UserDTO;
import com.plannerbe.domain.entity.User;

import org.jetbrains.annotations.NotNull;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public class UserMapper {
    public UserDTO toDTO(@NotNull User user) {
        return new UserDTO();
    }

    public User toEntity(@NotNull UserDTO userDTO) {
        return new User();
    }
}
