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
public class RaceDTO {

    private Long id;
    private String name;
    private LocalDate raceDate;
    private Integer round;
    private CircuitDTO circuit; // Nested DTO
    private SeasonDTO season; // Nested DTO
}