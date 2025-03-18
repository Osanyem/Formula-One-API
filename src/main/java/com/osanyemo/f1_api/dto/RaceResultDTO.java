package com.osanyemo.f1_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RaceResultDTO {

    private Long id;
    private Integer position;
    private Integer points;
    private Integer grid;
    private Integer laps;
    private String status;
    private String fastestLapTime;
    private DriverDTO driver; // Nested DTO
    private TeamDTO team; // Nested DTO
}