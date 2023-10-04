package com.plannerbe.domain.service;

import com.plannerbe.domain.dto.UserDTO;
import com.plannerbe.domain.entity.User;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Override public UserDTO createUser(User userDTO) {
        return null;
    }

    @Override public Optional<UserDTO> getUserById(Long id) {
        return Optional.empty();
    }

    @Override public UserDTO updateUser(Long id, UserDTO userDTO) {
        return null;
    }

    @Override public void deleteUser(Long id) {

    }

    @Override public List<UserDTO> findAllUsers() {
        return null;
    }

    @Override public User findByEmail(String email) {
        return null;
    }
}
