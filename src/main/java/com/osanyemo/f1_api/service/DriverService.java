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
public class DriverService {

    private final DriverRepository driverRepository;
    private final TeamRepository teamRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository, TeamRepository teamRepository) {
        this.driverRepository = driverRepository;
        this.teamRepository = teamRepository;
    }

    public List<Driver> getAllDrivers() {
        return (List<Driver>) driverRepository.findAll();
    }

    public Driver getDriverById(Long id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with id: " + id));
    }

    public List<Driver> getDriversByTeam(Long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));
        return driverRepository.findByCurrentTeam(team);
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver updateDriver(Driver driverDetails) {
        Driver driver = driverRepository.findById(driverDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with id: " + driverDetails.getId()));

        driver.setFirstName(driverDetails.getFirstName());
        driver.setLastName(driverDetails.getLastName());
        driver.setNationality(driverDetails.getNationality());
        driver.setDob(driverDetails.getDob());
        driver.setNumber(driverDetails.getNumber());
        driver.setCode(driverDetails.getCode());

        if (driverDetails.getCurrentTeam() != null) {
            Team team = teamRepository.findById(driverDetails.getCurrentTeam().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + driverDetails.getCurrentTeam().getId()));
            driver.setCurrentTeam(team);
        } else {
            driver.setCurrentTeam(null);
        }
        return driverRepository.save(driver);
    }

    public void deleteDriver(Long id) {
        Driver driver = driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Driver not found with id: " + id));
        driverRepository.delete(driver);
    }
}