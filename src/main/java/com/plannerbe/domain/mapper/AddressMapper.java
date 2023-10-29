package com.plannerbe.domain.mapper;

import com.plannerbe.domain.dto.AddressDTO;
import com.plannerbe.domain.entity.Address;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public AddressDTO toDTO(@NotNull Address address) {
        AddressDTO dto = new AddressDTO();
        dto.setCountry(address.getCountry());
        dto.setCity(address.getCity());
        dto.setStreet(address.getStreet());
        dto.setBuildingNumber(address.getBuildingNumber());
        dto.setPhone(address.getPhone());
        dto.setId(address.getId());
        return dto;
    }

    public Address toEntity(@NotNull AddressDTO addressDTO) {
        Address address = new Address();
        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setPhone(addressDTO.getPhone());
        return address;
    }
}
