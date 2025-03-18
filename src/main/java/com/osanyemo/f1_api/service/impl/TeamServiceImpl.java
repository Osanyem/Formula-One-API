package com.osanyemo.f1_api.service.impl;

import com.osanyemo.f1_api.dto.DriverDTO;
import com.osanyemo.f1_api.dto.TeamDTO;
import com.osanyemo.f1_api.entity.Team;
import com.osanyemo.f1_api.exception.ResourceNotFoundException;
import com.osanyemo.f1_api.repository.DriverRepository;
import com.osanyemo.f1_api.repository.TeamRepository;
import com.osanyemo.f1_api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final DriverRepository driverRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, DriverRepository driverRepository) {
        this.teamRepository = teamRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeamDTO getTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + id));
        return convertToDTO(team);
    }

    @Override
    public List<DriverDTO> getTeamDrivers(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));
        return driverRepository.findByCurrentTeam(team).stream()
                .map(this::convertToDriverDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TeamDTO createTeam(TeamDTO teamDTO) {
        Team team = convertToEntity(teamDTO);
        Team savedTeam = teamRepository.save(team);
        return convertToDTO(savedTeam);
    }

    @Override
    public TeamDTO updateTeam(Long id, TeamDTO teamDTO) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + id));
        updateEntity(team, teamDTO);
        Team updatedTeam = teamRepository.save(team);
        return convertToDTO(updatedTeam);
    }

    @Override
    public void deleteTeam(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + id));
        teamRepository.delete(team);
    }

    private TeamDTO convertToDTO(Team team) {
        return TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .nationality(team.getNationality())
                .baseLocation(team.getBaseLocation())
                .teamPrincipal(team.getTeamPrincipal())
                .constructor(team.getConstructor())
                .build();
    }

    private Team convertToEntity(TeamDTO teamDTO) {
        Team team = new Team();
        updateEntity(team, teamDTO);
        return team;
    }

    private void updateEntity(Team team, TeamDTO teamDTO) {
        team.setName(teamDTO.getName());
        team.setNationality(teamDTO.getNationality());
        team.setBaseLocation(teamDTO.getBaseLocation());
        team.setTeamPrincipal(teamDTO.getTeamPrincipal());
        team.setConstructor(teamDTO.getConstructor());
    }

    private DriverDTO convertToDriverDTO(Driver driver) {
        return DriverDTO.builder()
                .id(driver.getId())
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .nationality(driver.getNationality())
                .dateOfBirth(driver.getDate0fBirth())
                .number(driver.getNumber())
                .code(driver.getCode())
                .currentTeam(null) // Avoid recursion, do not include team details
                .build();
    }
}