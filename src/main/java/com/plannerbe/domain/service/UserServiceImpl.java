package com.plannerbe.domain.service;

import com.plannerbe.domain.dto.UserDTO;
import com.plannerbe.domain.entity.User;
import com.plannerbe.domain.mapper.UserMapper;
import com.plannerbe.domain.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    @Transactional
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    /*public void update() {
        User person = userRepository.findById(use);
        Address address = new Address();
        Address saved = addressRepository.save(address );
        person.getAddresses().add(saved);
    }*/

    @Transactional(readOnly = true)
    @Override
    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toDTO);
    }

    @Transactional
    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            User user = userMapper.toEntity(userDTO);
            user.setId(id);
            user = userRepository.save(user);
            return userMapper.toDTO(user);
        }
        return null;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll()
            .stream()
            .map(userMapper::toDTO)
            .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email).map(userMapper::toDTO);
    }
}
