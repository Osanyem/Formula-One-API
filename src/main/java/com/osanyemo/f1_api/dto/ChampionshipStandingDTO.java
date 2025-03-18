package com.osanyemo.f1_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChampionshipStandingDTO {

    private Integer position;
    private Integer points;
    private DriverDTO driver; // Nested DTO
    private Integer wins;
}