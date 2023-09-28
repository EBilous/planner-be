package com.plannerbe.domain.service;

import com.plannerbe.domain.dto.UserDTO;
import com.plannerbe.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser(User userDTO);

    Optional<UserDTO> getUserById(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    List<UserDTO> findAllUsers();

    User findByEmail(String email);
}
