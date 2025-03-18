package com.osanyemo.f1_api.service;

import com.osanyemo.f1_api.dto.DriverDTO;
import com.osanyemo.f1_api.dto.TeamDTO;
import java.util.List;

public interface TeamService {

    List<TeamDTO> getAllTeams();

    TeamDTO getTeamById(Long id);

    List<DriverDTO> getTeamDrivers(Long teamId);

    TeamDTO createTeam(TeamDTO teamDTO);

    TeamDTO updateTeam(Long id, TeamDTO teamDTO);

    void deleteTeam(Long id);
}