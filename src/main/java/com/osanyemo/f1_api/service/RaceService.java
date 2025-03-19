package com.osanyemo.f1_api.service;

import com.osanyemo.f1_api.entity.Circuit;
import com.osanyemo.f1_api.entity.Race;
import com.osanyemo.f1_api.entity.RaceResult;
import com.osanyemo.f1_api.entity.Season;
import com.osanyemo.f1_api.exception.ResourceNotFoundException;
import com.osanyemo.f1_api.repository.CircuitRepository;
import com.osanyemo.f1_api.repository.RaceRepository;
import com.osanyemo.f1_api.repository.RaceResultRepository;
import com.osanyemo.f1_api.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RaceService {

    private final RaceRepository raceRepository;
    private final CircuitRepository circuitRepository;
    private final SeasonRepository seasonRepository;
    private final RaceResultRepository raceResultRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository, CircuitRepository circuitRepository,
                       SeasonRepository seasonRepository, RaceResultRepository raceResultRepository) {
        this.raceRepository = raceRepository;
        this.circuitRepository = circuitRepository;
        this.seasonRepository = seasonRepository;
        this.raceResultRepository = raceResultRepository;
    }

    public List<Race> getAllRaces() {
        return (List<Race>) raceRepository.findAll();
    }

    public Race getRaceById(Long id) {
        return raceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Race not found with id: " + id));
    }



    public List<RaceResult> getRaceResults(Long raceId) {
        Race race = raceRepository.findById(raceId)
                .orElseThrow(() -> new ResourceNotFoundException("Race not found with id: " + raceId));
        return raceResultRepository.findByRace(race);
    }

    public Race createRace(Race race) {
        return raceRepository.save(race);
    }

    public Race updateRace(Race raceDetails) {
        Race race = raceRepository.findById(raceDetails.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Race not found with id: " + raceDetails.getId()));

        race.setName(raceDetails.getName());
        race.setRaceDate(raceDetails.getRaceDate());
        race.setRound(raceDetails.getRound());

        if (raceDetails.getCircuit() != null) {
            Circuit circuit = circuitRepository.findById(raceDetails.getCircuit().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Circuit not found with id: " + raceDetails.getCircuit().getId()));
            race.setCircuit(circuit);
        } else {
            race.setCircuit(null);
        }

        if (raceDetails.getSeason() != null) {
            Optional<Season> season = seasonRepository.findById(raceDetails.getSeason().getId());
            if (!season.isPresent()) {
                throw new ResourceNotFoundException("Season not found with id: " + raceDetails.getSeason().getId());
            }
            race.setSeason(season.get());
        } else {
            race.setSeason(null);
        }

        return raceRepository.save(race);
    }

    public void deleteRace(Long id) {
        Race race = raceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Race not found with id: " + id));
        raceRepository.delete(race);
    }
}