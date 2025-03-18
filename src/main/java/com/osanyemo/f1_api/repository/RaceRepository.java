package com.osanyemo.f1_api.repository;

import com.osanyemo.f1_api.entity.Race;
import com.osanyemo.f1_api.entity.RaceResult;
import com.osanyemo.f1_api.entity.Season;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RaceRepository extends CrudRepository<Race, Long> {

    List<Race> findBySeason(Season season);
}