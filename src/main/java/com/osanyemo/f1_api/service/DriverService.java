package com.osanyemo.f1_api.service;

import com.osanyemo.f1_api.dto.DriverDTO;
import java.util.List;

public interface DriverService {

    List<DriverDTO> getAllDrivers();

    DriverDTO getDriverById(Long id);

    List<DriverDTO> getDriversByTeam(Long teamId);

    DriverDTO createDriver(DriverDTO driverDTO);

    DriverDTO updateDriver(Long id, DriverDTO driverDTO);

    void deleteDriver(Long id);
}