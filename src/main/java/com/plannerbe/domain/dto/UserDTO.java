package com.plannerbe.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class UserDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private List<RoleDto> roleList = new ArrayList<>();
    private String password;
    private String phone;
    @JsonIgnore
    private Timestamp created_at;
    @JsonIgnore
    private Timestamp updated_at;
    private AddressDTO address;

    /**
     * DTO for {@link com.plannerbe.domain.entity.Role}
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public record RoleDto(Long id, String name) implements Serializable {
    }
}
