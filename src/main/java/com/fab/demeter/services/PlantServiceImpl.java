package com.fab.demeter.services;

import com.fab.demeter.models.Plant;
import com.fab.demeter.repositories.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("plantService")
public class PlantServiceImpl implements PlantService {

    @Autowired
    private PlantRepository repository;

    @Override
    public List<Plant> getAllPlants() {
        return this.repository.findAll();
    }

    @Override
    public Plant getPlantById(long id) {
        return this.repository.getOne(id);
    }

    @Override
    public Plant savePlant(Plant plant) {
        return this.repository.save(plant);
    }

    @Override
    public void deletePlantById(long id) {
        this.repository.deletePlantById(id);
    }
}
