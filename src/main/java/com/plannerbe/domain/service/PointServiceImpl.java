package com.plannerbe.domain.service;

import com.plannerbe.domain.dto.PointDTO;
import com.plannerbe.domain.entity.Point;
import com.plannerbe.domain.mapper.PointMapper;
import com.plannerbe.domain.repository.PointRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PointServiceImpl implements PointService{

    private final PointRepository pointRepository;
    private final PointMapper pointMapper;
    @Autowired
    public PointServiceImpl(PointRepository pointRepository, PointMapper pointMapper) {
        this.pointRepository = pointRepository;
        this.pointMapper = pointMapper;
    }

    @Override
    @Transactional
    public PointDTO createPoint(PointDTO pointDto) {
        Point point = pointMapper.toPointEntity(pointDto);
        point = pointRepository.save(point);
        return pointMapper.toPointDto(point);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PointDTO> getPointById(Long id) {
        return pointRepository.findById(id).map(pointMapper::toPointDto);
    }

    @Override public Optional<PointDTO> getPointByName(String name) {
        return Optional.empty();
    }

/*    @Override public Optional<PointDTO> getPointByName(String name) {
        return pointRepository.findFirstByNameIgnoreCase(name).get(pointMapper::toPointDto);
    }*/

    @Override public List<PointDTO> getPointByCity(String city) {
        return pointRepository.findAllByAddress_City(city).stream().map(pointMapper::toPointDto).collect(Collectors.toList());
    }
}
