package org.pitpitplants.services;

import lombok.extern.slf4j.Slf4j;
import org.pitpitplants.dtos.PlantDto;
import org.pitpitplants.entities.Plant;
import org.pitpitplants.entities.PlantNotFoundException;
import org.pitpitplants.entities.User;
import org.pitpitplants.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public List<Plant> getAllPants(){

        return plantRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Plant getPlantById(Long id){
        return plantRepository.getById(id);
    }

    public Plant addPlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public void deletePlant(Long id) {

        plantRepository.deleteById(id);
    }


    public Plant updatePlant(Long id, PlantDto plantDto){
        Plant plantToUpdate= plantRepository.findById(id).orElseThrow(()-> new PlantNotFoundException(id));
        log.info("plantToUpdate:"+plantToUpdate.getName());

        plantToUpdate.setName(plantDto.getName());
        plantToUpdate.setSpecies(plantDto.getSpecies());
        plantToUpdate.setCareTips(plantDto.getCareTips());
        plantToUpdate.setDescription(plantDto.getDescription());

        return plantRepository.save(plantToUpdate);
    }


//    public Plant deletePlant(Plant mapDtoToPlant) {
//        return plantRepository.delete();
//    }


//    public Plant createPlant(PlantDto plantDto, String username) {
//        // Convert the PlantDto to a Plant entity
//        Plant plant = convertToPlantEntity(plantDto);
//
//        // Set the user for the plant
//        User user = new User();
//        user.setUsername(username);
//        plant.setUser(user);
//
//        // Save the plant to the database
//        return plantRepository.save(plant);
//    }

//    private Plant convertToPlantEntity(PlantDto plantDto) {
//        Plant plant = new Plant();
//        plant.setName(plantDto.getName());
//        plant.setSpecies(plantDto.getSpecies());
//        plant.setDescription(plantDto.getDescription());
//        plant.setCareTips(plantDto.getCareTips());
//        return plant;
//    }
}
