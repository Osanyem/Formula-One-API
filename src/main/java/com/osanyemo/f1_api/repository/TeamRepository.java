package com.osanyemo.f1_api.repository;

import com.osanyemo.f1_api.entity.Driver;
import com.osanyemo.f1_api.entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {

}