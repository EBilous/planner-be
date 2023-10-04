package com.plannerbe.domain.repository;

import com.plannerbe.domain.entity.User;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    default Optional<User> findById(Long aLong) {
        return Optional.empty();
    }

    Optional<User> findByLastName(String surname);

    default void deleteById(Long aLong) {
    }

    @Override default List<User> findAll(Sort sort) {
        return null;
    }

    Optional<User> findByEmail(String email);
}
