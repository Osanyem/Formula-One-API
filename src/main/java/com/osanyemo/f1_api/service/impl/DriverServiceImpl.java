package com.osanyemo.f1_api.service.impl;

import com.osanyemo.f1_api.dto.DriverDTO;
import com.osanyemo.f1_api.dto.TeamDTO;
import com.osanyemo.f1_api.entity.Driver;
import com.osanyemo.f1_api.entity.Team;
import com.osanyemo.f1_api.exception.ResourceNotFoundException;
import com.osanyemo.f1_api.repository.DriverRepository;
import com.osanyemo.f1_api.repository.TeamRepository;
import com.osanyemo.f1_api.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository, TeamRepository teamRepository) {
        this.driverRepository = driverRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<DriverDTO> getAllDrivers() {
        return driverRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DriverDTO getDriverById(Long id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with id: " + id));
        return convertToDTO(driver);
    }

    @Override
    public List<DriverDTO> getDriversByTeam(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));
        return driverRepository.findByCurrentTeam(team).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DriverDTO createDriver(DriverDTO driverDTO) {
        Driver driver = convertToEntity(driverDTO);
        Driver savedDriver = driverRepository.save(driver);
        return convertToDTO(savedDriver);
    }

    @Override
    public DriverDTO updateDriver(Long id, DriverDTO driverDTO) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with id: " + id));
        updateEntity(driver, driverDTO);
        Driver updatedDriver = driverRepository.save(driver);
        return convertToDTO(updatedDriver);
    }

    @Override
    public void deleteDriver(Long id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with id: " + id));
        driverRepository.delete(driver);
    }

    private DriverDTO convertToDTO(Driver driver) {
        return DriverDTO.builder()
                .id(driver.getId())
                .firstName(driver.getFirstName())
                .lastName(driver.getLastName())
                .nationality(driver.getNationality())
                .dateOfBirth(driver.getDate0fBirth())
                .number(driver.getNumber())
                .code(driver.getCode())
                .currentTeam(driver.getCurrentTeam() != null ? convertToTeamDTO(driver.getCurrentTeam()) : null)
                .build();
    }

    private Driver convertToEntity(DriverDTO driverDTO) {
        Driver driver = new Driver();
        updateEntity(driver, driverDTO);
        return driver;
    }

    private void updateEntity(Driver driver, DriverDTO driverDTO) {
        driver.setFirstName(driverDTO.getFirstName());
        driver.setLastName(driverDTO.getLastName());
        driver.setNationality(driverDTO.getNationality());
        if (driverDTO.getDateOfBirth() != null) {
            driver.setDate0fBirth(driverDTO.getDateOfBirth());
        }
        if (driverDTO.getNumber() != null) {
            driver.setNumber(driverDTO.getNumber());
        }
        driver.setCode(driverDTO.getCode());
        if (driverDTO.getCurrentTeam() != null) {
            Team team = teamRepository.findById(driverDTO.getCurrentTeam().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + driverDTO.getCurrentTeam().getId()));
            driver.setCurrentTeam(team);
        } else {
            driver.setCurrentTeam(null);
        }
    }

    private TeamDTO convertToTeamDTO(Team team) {
        return TeamDTO.builder()
                .id(team.getId())
                .name(team.getName())
                .nationality(team.getNationality())
                .baseLocation(team.getBaseLocation())
                .teamPrincipal(team.getTeamPrincipal())
                .constructor(team.getConstructor())
                .build();
    }
}