package com.cognizant.ormlearn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country") // make sure this table exists in your DB
public class Country {

    @Id
    private String code;

    private String name;

    // Add getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Optional: toString()
    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + "]";
    }
}
