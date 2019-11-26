package com.project_1.hardware_community.repositories;

import com.project_1.hardware_community.domain.Ram;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RamRepository extends CrudRepository<Ram, Long> {
    List<Ram> findByName(String name);
}