package com.plannerbe.domain.repository;

import com.plannerbe.domain.entity.Address;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface AddressRepository extends JpaRepository<Address, Long> {
    @NotNull
    Optional<Address> findById(@NotNull Long id);
}
