package com.project_1.hardware_community.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Cpu extends Product{

    private String socket;
    private String core;
    private String coreQuantity;
    private String threadQuantity;
    private String frequency;

    public Cpu() {
    }

    public Cpu(String brand,
               String name,
               String socket,
               String core,
               String coreQuantity,
               String threadQuantity,
               String frequency) {
        this.brand = brand;
        this.name = name;
        this.socket = socket;
        this.core = core;
        this.coreQuantity = coreQuantity;
        this.threadQuantity = threadQuantity;
        this.frequency = frequency;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        this.dateOfAdding = formatter.format(date);
    }

    public boolean contains(String keyWord) {
        if (brand.contains(keyWord) ||
                name.contains(keyWord) ||
                socket.contains(keyWord) ||
                core.contains(keyWord) ||
                frequency.contains(keyWord)) {
            return true;
        } else {
            return false;
        }
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public String getCoreQuantity() {
        return coreQuantity;
    }

    public void setCoreQuantity(String coreQuantity) {
        this.coreQuantity = coreQuantity;
    }

    public String getThreadQuantity() {
        return threadQuantity;
    }

    public void setThreadQuantity(String threadQuantity) {
        this.threadQuantity = threadQuantity;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}