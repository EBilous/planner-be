package com.plannerbe.domain.service;

import com.plannerbe.domain.dto.UserDTO;
import com.plannerbe.domain.entity.User;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserService {

    @Transactional UserDTO createUser(UserDTO userDTO);

    @Transactional(readOnly = true) Optional<UserDTO> getUserById(Long id);

    @Transactional UserDTO updateUser(Long id, UserDTO userDTO);

    @Transactional void deleteUser(Long id);

    @Transactional List<UserDTO> findAllUsers();

    @Transactional Optional<UserDTO> findByEmail(String email);
}
