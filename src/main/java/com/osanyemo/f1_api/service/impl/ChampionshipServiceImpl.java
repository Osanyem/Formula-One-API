package com.osanyemo.f1_api.service.impl;

import com.osanyemo.f1_api.dto.ChampionshipStandingDTO;
import com.osanyemo.f1_api.dto.DriverDTO;
import com.osanyemo.f1_api.dto.TeamDTO;
import com.osanyemo.f1_api.entity.Driver;
import com.osanyemo.f1_api.entity.RaceResult;
import com.osanyemo.f1_api.entity.Season;
import com.osanyemo.f1_api.entity.Team;
import com.osanyemo.f1_api.exception.ResourceNotFoundException;
import com.osanyemo.f1_api.repository.RaceResultRepository;
import com.osanyemo.f1_api.repository.SeasonRepository;
import com.osanyemo.f1_api.service.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChampionshipServiceImpl implements ChampionshipService {

    private final RaceResultRepository raceResultRepository;
    private final SeasonRepository seasonRepository;

    @Autowired
    public ChampionshipServiceImpl(RaceResultRepository raceResultRepository,
                                   SeasonRepository seasonRepository) {
        this.raceResultRepository = raceResultRepository;
        this.seasonRepository = seasonRepository;
    }

    @Override
    public List<ChampionshipStandingDTO> getDriverStandings(int year) {
        Season season = seasonRepository.findByYear(year)
                .orElseThrow(() -> new ResourceNotFoundException("Season not found for year: " + year));
        List<RaceResult> results = raceResultRepository.findByRace_Season(season);

        Map<Driver, Integer> pointsByDriver = new HashMap<>();
        Map<Driver, Integer> winsByDriver = new HashMap<>();

        // Calculate points and wins for each driver
        for (RaceResult result : results) {
            Driver driver = result.getDriver();
            pointsByDriver.put(driver, pointsByDriver.getOrDefault(driver, 0) + result.getPoints());
            if (result.getPosition() == 1) {
                winsByDriver.put(driver, winsByDriver.getOrDefault(driver, 0) + 1);
            }
        }

        // Convert to DTOs and sort by points
        List<ChampionshipStandingDTO> standings = new ArrayList<>();
        pointsByDriver.forEach((driver, points) -> {
            ChampionshipStandingDTO dto = new ChampionshipStandingDTO();
            dto.setDriver(convertToDriverDTO(driver));
            dto.setPoints(points);
            dto.setWins(winsByDriver.getOrDefault(driver, 0));
            standings.add(dto);
        });

        // Sort by points (descending)
        standings.sort((a, b) -> b.getPoints() - a.getPoints());

        // Set positions
        for (int i = 0; i < standings.size(); i++) {
            standings.get(i).setPosition(i + 1);
        }

        return standings;
    }

    @Override
    public List<ChampionshipStandingDTO> getTeamStandings(int year) {
        Season season = seasonRepository.findByYear(year)
                .orElseThrow(() -> new ResourceNotFoundException("Season not found for year: " + year));
        List<RaceResult> results = raceResultRepository.findByRace_Season(season);

        Map<Team, Integer> pointsByTeam = new HashMap<>();
        Map<Team, Integer> winsByTeam = new HashMap<>();

        // Calculate points and wins for each team
        for (RaceResult result : results) {
            Team team = result.getTeam();
            pointsByTeam.put(team, pointsByTeam.getOrDefault(team, 0) + result.getPoints());
            if (result.getPosition() == 1) {
                winsByTeam.put(team, winsByTeam.getOrDefault(team, 0) + 1);
            }
        }

        // Convert to DTOs and sort by points
        List<ChampionshipStandingDTO> standings = new ArrayList<>();
        pointsByTeam.forEach((team, points) -> {
            ChampionshipStandingDTO dto = new ChampionshipStandingDTO();
            dto.setTeam(convertToTeamDTO(team)); // Using proper TeamDTO
            dto.setPoints(points);
            dto.setWins(winsByTeam.getOrDefault(team, 0));
            standings.add(dto);
        });

        // Sort by points (descending)
        standings.sort((a, b) -> b.getPoints() - a.getPoints());

        // Set positions
        for (int i = 0; i < standings.size(); i++) {
            standings.get(i).setPosition(i + 1);
        }

        return standings;
    }

    @Override
    public List<ChampionshipStandingDTO> getCurrentDriverStandings() {
        int currentYear = getCurrentYear();
        return getDriverStandings(currentYear);
    }

    @Override
    public List<ChampionshipStandingDTO> getCurrentTeamStandings() {
        int currentYear = getCurrentYear();
        return getTeamStandings(currentYear);
    }

    private DriverDTO convertToDriverDTO(Driver driver) {
        DriverDTO dto = DriverDTO.builder()
                .id(driver.getId())
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .nationality(driver.getNationality())
                .dateOfBirth(driver.getDate0fBirth())
                .number(driver.getNumber())
                .code(driver.getCode())
                .build();

        if (driver.getCurrentTeam() != null) {
            dto.setCurrentTeam(convertToTeamDTO(driver.getCurrentTeam()));
        }
        return dto;
    }

    private TeamDTO convertToTeamDTO(Team team) {
        return TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .constructor(team.getConstructor())
                .build();
    }

    private int getCurrentYear() {
        return java.time.LocalDate.now().getYear();
    }
}