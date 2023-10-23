package com.plannerbe.domain.repository;

import com.plannerbe.domain.entity.Address;
import com.plannerbe.domain.entity.Point;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface AddressRepository {
    @NotNull
    Optional<Address> findById(@NotNull Long id);
}
