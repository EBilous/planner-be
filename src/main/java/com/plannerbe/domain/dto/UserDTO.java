package com.plannerbe.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String password;
    private Timestamp created_at;
    private Timestamp updated_at;
    private List<RoleDTO> roleList;
}
