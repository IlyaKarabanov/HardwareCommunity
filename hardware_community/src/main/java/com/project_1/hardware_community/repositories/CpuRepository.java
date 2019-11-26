package com.project_1.hardware_community.repositories;

import com.project_1.hardware_community.domain.Cpu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CpuRepository extends CrudRepository<Cpu, Long> {
    List<Cpu> findByBrandContainsOrNameContainsOrSocketContainsOrCoreContainsOrFrequencyContains(String brand,
                                                                                                 String name,
                                                                                                 String socket,
                                                                                                 String core,
                                                                                                 String frequency);
    Cpu findById(Integer id);
    List<Cpu> findAll();
}
