package com.project_1.hardware_community.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Gpu extends Product {

    private String memoryFrequency;
    private String gpuFrequency;
    private String memory;
    private String type;

    public Gpu() {}

    public Gpu(String brand,
               String name,
               String memoryFrequency,
               String gpuFrequency,
               String memory,
               String type) {
        this.brand = brand;
        this.name = name;
        this.memoryFrequency = memoryFrequency;
        this.gpuFrequency = gpuFrequency;
        this.memory = memory;
        this.type = type;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        this.dateOfAdding = formatter.format(date);
    }

    public String getMemoryFrequency() {
        return memoryFrequency;
    }

    public void setMemoryFrequency(String memoryFrequancy) {
        this.memoryFrequency = memoryFrequancy;
    }

    public String getGpuFrequency() {
        return gpuFrequency;
    }

    public void setGpuFrequency(String gpuFrequancy) {
        this.gpuFrequency = gpuFrequancy;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
