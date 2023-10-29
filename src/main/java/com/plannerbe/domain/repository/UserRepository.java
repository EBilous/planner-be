package com.plannerbe.domain.repository;

import com.plannerbe.domain.dto.UserDTO;
import com.plannerbe.domain.entity.User;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /*default Optional<UserDTO> findUserById(Long id) {
        return null;
    }*/

    @Override Optional<User> findById(Long aLong);

    Optional<User> findByLastName(String surname);

    default void deleteById(Long aLong) {
    }

    @Override default List<User> findAll(Sort sort) {
        return null;
    }

    Optional<User> findByEmail(String email);
}
