package com.project_1.hardware_community.repositories;

import com.project_1.hardware_community.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);
    Product findById(Integer id);
}