package com.osanyemo.f1_api.service;

import com.osanyemo.f1_api.dto.RaceDTO;
import com.osanyemo.f1_api.dto.RaceResultDTO;

import java.util.List;

public interface RaceService {

    List<RaceDTO> getAllRaces();

    RaceDTO getRaceById(Long id);

    List<RaceDTO> getRacesBySeason(int year);

    List<RaceResultDTO> getRaceResults(Long raceId);

    RaceDTO createRace(RaceDTO raceDTO);

    RaceDTO updateRace(Long id, RaceDTO raceDTO);

    void deleteRace(Long id);
}