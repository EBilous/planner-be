package com.plannerbe.domain.repository;

import com.plannerbe.domain.entity.Point;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PointRepository extends JpaRepository<Point, Long> {
    @Override Optional<Point> findById(Long aLong);
    Optional<Point> findFirstByNameIgnoreCase(String name);
    Optional<Point> findPointByCategoriesListContaining(String category);



}