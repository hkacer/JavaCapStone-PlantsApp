package org.pitpitplants.dtos;
// Plant DTO class
public class PlantDto {
    private Long id;
    private String name;
    private String species;
    private String description;

    public String getCareTips() {
        return careTips;
    }

    public void setCareTips(String careTips) {
        this.careTips = careTips;
    }

    private String careTips;
    private Long userId;

    public PlantDto() {}

    public PlantDto(Long id, String name, String species, String description, String careTips, Long userId) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.description = description;
        this.careTips=careTips;
        this.userId = userId;
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}