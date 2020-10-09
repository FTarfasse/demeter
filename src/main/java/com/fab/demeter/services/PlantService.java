package com.fab.demeter.services;

import com.fab.demeter.models.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantService {
    List<Plant> getAllPlants();
    Plant getPlantById(long id);
    Plant savePlant(Plant plant);
    void deletePlantById(long id);
}
