package com.plannerbe.domain.controller;

import com.plannerbe.domain.dto.PointDTO;
import com.plannerbe.domain.mapper.PointMapper;
import com.plannerbe.domain.service.PointService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class PointController {
    private final PointService service;
    private final PointMapper pointMapper;

    @Autowired
    public PointController(PointService service,
                           PointMapper pointMapper) {
        this.service = service;
        this.pointMapper = pointMapper;
    }

    @PreAuthorize(value = "hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/poi/add")
    public ResponseEntity<PointDTO> createPoint(@RequestBody PointDTO pointDTO){
        return ResponseEntity.ok(service.createPoint(pointDTO));
    }

    @PreAuthorize(value = "hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/poi/get/{id}")
    public ResponseEntity<Optional<PointDTO>> getPointById(@PathVariable Long id){
        return ResponseEntity.ok(service.getPointById(id));
    }

}
