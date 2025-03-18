package com.osanyemo.f1_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CircuitDTO {
    private Long id;
    private String name;
    private String location;
    private String country;
    private Double length; // in km
    private Integer numberOfLaps;
}