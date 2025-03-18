package com.osanyemo.f1_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DriverDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String nationality;
    private LocalDate dateOfBirth;
    private Integer number;
    private String code;
    private TeamDTO currentTeam; // Nested DTO
}