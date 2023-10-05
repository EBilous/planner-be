package com.plannerbe.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class AddressDTO {
    private String country;
    private String city;
    private String street;
    private String buildingNumber;
    private String phone;
    private String latitude;
    private String longitude;
}
