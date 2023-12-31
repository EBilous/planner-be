package com.plannerbe.domain.repository;

import com.plannerbe.domain.entity.User;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    default @NotNull Optional<User> findById(@NotNull Long id) {
        return Optional.empty();
    }

    Optional<User> findByLastName(String surname);

    default void deleteById(@NotNull Long aLong) {
    }

    @Override default @NotNull List<User> findAll(@NotNull Sort sort) {
        return null;
    }

    Optional<User> findByEmail(String email);
}
