package com.osanyemo.f1_api.repository;

import com.osanyemo.f1_api.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}