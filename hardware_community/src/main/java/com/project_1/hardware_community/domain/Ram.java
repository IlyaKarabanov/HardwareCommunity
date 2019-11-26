package com.project_1.hardware_community.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Ram extends Product {
    private String type;
    private String memory;
    private String frequency;

    public Ram() {}

    public Ram(String brand,
               String name,
               String type,
               String memory,
               String frequency) {
        this.brand = brand;
        this.name = name;
        this.type = type;
        this.memory = memory;
        this.frequency = frequency;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        this.dateOfAdding = formatter.format(date);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequancy) {
        this.frequency = frequancy;
    }
}