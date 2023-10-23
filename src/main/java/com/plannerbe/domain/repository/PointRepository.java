package com.plannerbe.domain.repository;

import com.plannerbe.domain.dto.PointDTO;
import com.plannerbe.domain.entity.Point;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PointRepository extends JpaRepository<Point, Long> {
    @Override @NotNull Optional<Point> findById(@NotNull Long id);

    @Override @NotNull List<Point> findAll();

    List<Point> findFirstByNameIgnoreCase(String name);

    List<Point> findPointsByName(Collection<String> names, Sort sort);

    List<Point> findAllByAddress_City(String city);

}