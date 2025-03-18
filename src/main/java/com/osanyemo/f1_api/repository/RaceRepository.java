package com.osanyemo.f1_api.repository;

import com.osanyemo.f1_api.entity.Race;
import org.springframework.data.repository.CrudRepository;

public interface RaceRepository extends CrudRepository<Race, Long> {
}