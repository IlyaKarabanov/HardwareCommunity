package com.project_1.hardware_community.repositories;

import com.project_1.hardware_community.domain.Gpu;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GpuRepository extends CrudRepository<Gpu, Long> {
    //findByBrandContainsOrNameContainsOr
    List<Gpu> findByName(String name);
}
