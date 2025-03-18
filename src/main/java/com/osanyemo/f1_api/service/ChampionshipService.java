package com.osanyemo.f1_api.service;

import com.osanyemo.f1_api.dto.ChampionshipStandingDTO;

import java.util.List;

public interface ChampionshipService {

    List<ChampionshipStandingDTO> getDriverStandings(int year);

    List<ChampionshipStandingDTO> getTeamStandings(int year);

    List<ChampionshipStandingDTO> getCurrentDriverStandings();

    List<ChampionshipStandingDTO> getCurrentTeamStandings();
}