package org.pitpitplants.controllers;

import lombok.extern.slf4j.Slf4j;
import org.pitpitplants.dtos.PlantDto;
import org.pitpitplants.entities.Plant;
import org.pitpitplants.mappers.PlantMapper;
import org.pitpitplants.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class PlantController {

    @Autowired
    private PlantService plantService;

    @Autowired
    PlantMapper plantMapper;

    @GetMapping("/allplants")
    public List<Plant> getAllPlants(){
        return plantService.getAllPants();
    }

    @GetMapping("/plants/{id}")
    public ResponseEntity<Plant> getPlantById(@PathVariable Long id) {
        Plant plant = plantService.getPlantById(id);
        if (plant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(plant, HttpStatus.OK);
    }

    @PostMapping("/saveplant")
    public ResponseEntity<Plant> savePlant(@RequestBody PlantDto plantDto){
        return new ResponseEntity<>(this.plantService.addPlant(PlantMapper.mapDtoToPlant(plantDto)), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePlant/{id}")
    public ResponseEntity<Void> deletePlant(@PathVariable Long id) {
        log.info("id:"+id);
        plantService.deletePlant(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updatePlant/{id}")
    public ResponseEntity<Plant> updatePlant(@PathVariable Long id, @RequestBody PlantDto plantDto){
        log.info("id:"+id);
        log.info("plantDto:"+plantDto);
        Plant updatePlant= plantService.updatePlant(id, plantDto);

        return ResponseEntity.ok(updatePlant);
    }

}
