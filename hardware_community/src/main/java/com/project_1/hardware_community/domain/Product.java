package com.project_1.hardware_community.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Inheritance
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;

    protected String brand;
    protected String name;
    protected String dateOfAdding;
    protected String dateOfLastChange;

    public Product() {
    }

    public Product(String brand, String name) {
        this.brand = brand;
        this.name = name;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        this.dateOfAdding = formatter.format(date);
        this.dateOfLastChange = formatter.format(date);
    }

    public void change() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        this.dateOfLastChange = formatter.format(date);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String model) {
        this.name = model;
    }

    public String getDateOfAdding() {
        return dateOfAdding;
    }

    public void setDateOfAdding(String dateOfAdding) {
        this.dateOfAdding = dateOfAdding;
    }

    public String getDateOfLastChange() {
        return dateOfLastChange;
    }

    public void setDateOfLastChange(String dateOfLastChange) {
        this.dateOfLastChange = dateOfLastChange;
    }
}
