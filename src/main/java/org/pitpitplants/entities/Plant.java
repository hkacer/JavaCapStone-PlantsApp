package org.pitpitplants.entities;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Plant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    private String species;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Column
    private String description;
    @Column
    private String careTips;

    public Plant() {}

    public Plant(String name, String description, String careTips) {
        this.name = name;
        this.description = description;
        this.careTips = careTips;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCareTips() {
        return careTips;
    }

    public void setCareTips(String careTips) {
        this.careTips = careTips;
    }

    public void setUser(User user) {
    }
}
