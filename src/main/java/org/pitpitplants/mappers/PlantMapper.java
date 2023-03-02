package org.pitpitplants.mappers;

import org.pitpitplants.dtos.PlantDto;
import org.pitpitplants.entities.Plant;
import org.pitpitplants.entities.User;
import org.springframework.stereotype.Service;

@Service
public class PlantMapper {

    public static Plant mapDtoToPlant(PlantDto plantDto) {
        Plant plant = new Plant();
        plant.setId(plantDto.getId());
        plant.setName(plantDto.getName());
        plant.setSpecies(plantDto.getSpecies());
        plant.setDescription(plantDto.getDescription());
        plant.setCareTips(plantDto.getCareTips());
        return plant;
    }
}
