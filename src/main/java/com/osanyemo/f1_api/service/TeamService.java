package com.osanyemo.f1_api.service;

import com.osanyemo.f1_api.entity.Driver;
import com.osanyemo.f1_api.entity.Team;
import com.osanyemo.f1_api.exception.ResourceNotFoundException;
import com.osanyemo.f1_api.repository.DriverRepository;
import com.osanyemo.f1_api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;
    private final DriverRepository driverRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository, DriverRepository driverRepository) {
        this.teamRepository = teamRepository;
        this.driverRepository = driverRepository;
    }

    public List<Team> getAllTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    public Team getTeamById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + id));
    }

    public List<Driver> getTeamDrivers(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));
        return driverRepository.findByCurrentTeam(team);
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public Team updateTeam(Team teamDetails) {
        Team team = teamRepository.findById(teamDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamDetails.getId()));

        team.setName(teamDetails.getName());
        team.setNationality(teamDetails.getNationality());
        team.setBaseLocation(teamDetails.getBaseLocation());
        team.setTeamPrincipal(teamDetails.getTeamPrincipal());
        team.setConstructor(teamDetails.getConstructor());

        return teamRepository.save(team);
    }

    public void deleteTeam(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + id));
        teamRepository.delete(team);
    }
}