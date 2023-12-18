package com.plannerbe.domain.service;

import com.plannerbe.domain.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    Optional<UserDTO> findById(Long id);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);

    List<UserDTO> findAllUsers();

    Optional<UserDTO> findByEmail(String email);

    List<UserDTO> findByLastName(String lastName);
}
