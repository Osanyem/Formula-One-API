package com.osanyemo.f1_api.service.impl;

import com.osanyemo.f1_api.dto.*;
import com.osanyemo.f1_api.entity.Circuit;
import com.osanyemo.f1_api.entity.Race;
import com.osanyemo.f1_api.entity.RaceResult;
import com.osanyemo.f1_api.entity.Season;
import com.osanyemo.f1_api.exception.ResourceNotFoundException;
import com.osanyemo.f1_api.repository.CircuitRepository;
import com.osanyemo.f1_api.repository.RaceRepository;
import com.osanyemo.f1_api.repository.RaceResultRepository;
import com.osanyemo.f1_api.repository.SeasonRepository;
import com.osanyemo.f1_api.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RaceServiceImpl implements RaceService {

    private final RaceRepository raceRepository;
    private final CircuitRepository circuitRepository;
    private final SeasonRepository seasonRepository;
    private final RaceResultRepository raceResultRepository;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository, CircuitRepository circuitRepository,
                           SeasonRepository seasonRepository, RaceResultRepository raceResultRepository) {
        this.raceRepository = raceRepository;
        this.circuitRepository = circuitRepository;
        this.seasonRepository = seasonRepository;
        this.raceResultRepository = raceResultRepository;
    }

    @Override
    public List<RaceDTO> getAllRaces() {
        return raceRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RaceDTO getRaceById(Long id) {
        Race race = raceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Race not found with id: " + id));
        return convertToDTO(race);
    }

    @Override
    public List<RaceDTO> getRacesBySeason(int year) {
        Season season = seasonRepository.findByYear(year)
                .orElseThrow(() -> new ResourceNotFoundException("Season not found for year: " + year));
        return raceRepository.findBySeason(season).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RaceResultDTO> getRaceResults(Long raceId) {
        Race race = raceRepository.findById(raceId)
                .orElseThrow(() -> new ResourceNotFoundException("Race not found with id: " + raceId));
        return raceResultRepository.findByRace(race).stream()
                .map(this::convertToRaceResultDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RaceDTO createRace(RaceDTO raceDTO) {
        Race race = convertToEntity(raceDTO);
        Race savedRace = raceRepository.save(race);
        return convertToDTO(savedRace);
    }

    @Override
    public RaceDTO updateRace(Long id, RaceDTO raceDTO) {
        Race race = raceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Race not found with id: " + id));
        updateEntity(race, raceDTO);
        Race updatedRace = raceRepository.save(race);
        return convertToDTO(updatedRace);
    }

    @Override
    public void deleteRace(Long id) {
        Race race = raceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Race not found with id: " + id));

        // Delete related race results first to avoid foreign key constraints
        List<RaceResult> results = raceResultRepository.findByRace(race);
        raceResultRepository.deleteAll(results);

        // Now delete the race
        raceRepository.delete(race);
    }

    private RaceDTO convertToDTO(Race race) {
        return RaceDTO.builder()
                .id(race.getId())
                .name(race.getName())
                .raceDate(race.getRaceDate())
                .round(race.getRound())
                .circuit(race.getCircuit() != null ? convertToCircuitDTO(race.getCircuit()) : null)
                .season(race.getSeason() != null ? convertToSeasonDTO(race.getSeason()) : null)
                .build();
    }

    private Race convertToEntity(RaceDTO raceDTO) {
        Race race = new Race();
        updateEntity(race, raceDTO);
        return race;
    }

    private void updateEntity(Race race, RaceDTO raceDTO) {
        race.setName(raceDTO.getName());
        if (raceDTO.getRaceDate() != null) {
            race.setRaceDate(raceDTO.getRaceDate());
        }
        if (raceDTO.getRound() != null) {
            race.setRound(raceDTO.getRound());
        }
        if (raceDTO.getCircuit() != null) {
            Circuit circuit = circuitRepository.findById(raceDTO.getCircuit().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Circuit not found with id: " + raceDTO.getCircuit().getId()));
            race.setCircuit(circuit);
        } else {
            race.setCircuit(null);
        }
        if (raceDTO.getSeason() != null) {
            Season season = seasonRepository.findById(raceDTO.getSeason().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Season not found with id: " + raceDTO.getSeason().getId()));
            race.setSeason(season);
        } else {
            race.setSeason(null);
        }
    }

    private CircuitDTO convertToCircuitDTO(Circuit circuit) {
        return CircuitDTO.builder()
                .id(circuit.getId())
                .name(circuit.getName())
                .location(circuit.getLocation())
                .country(circuit.getCountry())
                .length(circuit.getLength())
                .numberOfLaps(circuit.getNumberOfLaps())
                .lapRecord(circuit.getLapRecord())
                .build();
    }

    private SeasonDTO convertToSeasonDTO(Season season) {
        return SeasonDTO.builder()
                .id(season.getId())
                .year(season.getYear())
                .build();
    }

    private RaceResultDTO convertToRaceResultDTO(RaceResult raceResult) {
        return RaceResultDTO.builder()
                .id(raceResult.getId())
                .position(raceResult.getPosition())
                .points(raceResult.getPoints())
                .grid(raceResult.getGrid())
                .laps(raceResult.getLaps())
                .status(raceResult.getStatus())
                .fastestLapTime(raceResult.getFastestLapTime())
                .driver(raceResult.getDriver() != null ? convertToDriverDTO(raceResult.getDriver()) : null)
                .team(raceResult.getTeam() != null ? convertToTeamDTO(raceResult.getTeam()) : null)
                .build();
    }

    private DriverDTO convertToDriverDTO(com.osanyemo.f1_api.entity.Driver driver) {
        return DriverDTO.builder()
                .id(driver.getId())
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .code(driver.getCode())
                .currentTeam(null) // Avoid recursion
                .build();
    }

    private TeamDTO convertToTeamDTO(com.osanyemo.f1_api.entity.Team team) {
        return TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .constructor(team.getConstructor())
                .build();
    }
}