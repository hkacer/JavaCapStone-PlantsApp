package org.pitpitplants.entities;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PlantNotFoundException extends RuntimeException {
    public PlantNotFoundException(Long id) {
        super("Plant not found with ID: " + id);
    }
}