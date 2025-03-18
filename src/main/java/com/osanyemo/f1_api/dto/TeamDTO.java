package com.osanyemo.f1_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDTO {

    private Long id;
    private String name;
    private String nationality;
    private String baseLocation;
    private String teamPrincipal;
    private String constructor;
}