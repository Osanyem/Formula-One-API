package com.osanyemo.f1_api.controller;

import com.osanyemo.f1_api.entity.Race;
import com.osanyemo.f1_api.entity.RaceResult;
import com.osanyemo.f1_api.service.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RaceController {

    private final RaceService raceService;

    @Autowired
    public RaceController(RaceService raceService) {
        this.raceService = raceService;
    }

    @GetMapping("/races")
    public ResponseEntity<List<Race>> getAllRaces() {
        return ResponseEntity.ok(raceService.getAllRaces());
    }

    @GetMapping("/races/{id}")
    public ResponseEntity<Race> getRaceById(@PathVariable Long id) {
        return ResponseEntity.ok(raceService.getRaceById(id));
    }


    @GetMapping("/races/{id}/results")
    public ResponseEntity<List<RaceResult>> getRaceResults(@PathVariable Long id) {
        return ResponseEntity.ok(raceService.getRaceResults(id));
    }

    @PostMapping("/races")
    public ResponseEntity<Race> createRace(@RequestBody Race race) {
        return new ResponseEntity<>(raceService.createRace(race), HttpStatus.CREATED);
    }

    @PutMapping("/races/{id}")
    public ResponseEntity<Race> updateRace(@PathVariable Long id, @RequestBody Race race) {
        race.setId(id);
        return ResponseEntity.ok(raceService.updateRace(race));
    }
//  TODO: Implement cascading deletion in the entities to get it to work
//    @DeleteMapping("/races/{id}")
//    public ResponseEntity<Void> deleteRace(@PathVariable Long id) {
//        raceService.deleteRace(id);
//        return ResponseEntity.noContent().build();
//    }
}