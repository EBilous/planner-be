package com.plannerbe.domain.service;

import com.plannerbe.domain.dto.PointDTO;
import com.plannerbe.domain.entity.Address;
import com.plannerbe.domain.entity.Point;
import com.plannerbe.domain.mapper.AddressMapper;
import com.plannerbe.domain.mapper.PointMapper;
import com.plannerbe.domain.repository.AddressRepository;
import com.plannerbe.domain.repository.PointRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PointServiceImpl implements PointService {

    private final PointRepository pointRepository;
    private final PointMapper pointMapper;
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Autowired
    public PointServiceImpl(PointRepository pointRepository, PointMapper pointMapper,
                            AddressRepository addressRepository, AddressMapper addressMapper1) {
        this.pointRepository = pointRepository;
        this.pointMapper = pointMapper;
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper1;
    }

    @Override
    @Transactional
    public PointDTO createPoint(PointDTO pointDto) {
        Point point = pointMapper.toEntity(pointDto);
        Address address = addressMapper.toEntity(pointDto.getAddress());
        point.setAddress(address);
        point = pointRepository.save(point);
        return pointMapper.toDTO(point);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PointDTO> getPointById(Long id) {
        return pointRepository.findById(id).map(pointMapper::toDTO);
    }

    @Override public Optional<PointDTO> getPointByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<PointDTO> getPointByCity(String city) {
        return pointRepository.findAllByAddress_City(city).stream().map(pointMapper::toDTO).collect(Collectors.toList());
    }
}
