package com.osanyemo.f1_api.repository;

import com.osanyemo.f1_api.entity.Driver;
import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Long> {
}