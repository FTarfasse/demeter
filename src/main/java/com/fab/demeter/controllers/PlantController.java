package com.fab.demeter.controllers;

import com.fab.demeter.models.Plant;
import com.fab.demeter.services.PlantService;
import com.fab.demeter.utils.PlantNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping("v0/api/plants")
@RestController("plantController")
public class PlantController {

    private static final Logger log = LoggerFactory.getLogger(PlantController.class);

    @Autowired
    private PlantService service;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Plant>> getAllPlants(){
        this.log.info("Returning all the plants !");
        return new ResponseEntity<>(service.getAllPlants(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Plant> getPlantById(@PathVariable("id") long id){
        this.log.info("Returning plant with id: " + id);
//        Optional<Plant> searchedPlant = this.service.getPlantById(id);
        Plant searchedPlant = this.service.getPlantById(id);

        if(searchedPlant == null || searchedPlant.getId() <= 0){
            throw new PlantNotFoundException("Plant with id " + id + " doesn't exist !");
        }

        return new ResponseEntity<>(searchedPlant, HttpStatus.OK) ;
    }

    /**
     * <a href="https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/DELETE">MDN</a> According to Mozilla,
     * acceptable responses are:
     * - 202 (Accepted) status code if the action will likely succeed but has not yet been enacted.
     * - 204 (No Content) status code if the action has been enacted and no further information is to be supplied.
     * - 200 (OK) status code if the action has been enacted and the response message includes a representation
     *      describing the status.
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> removePlant(@PathVariable("id") long id){
        this.log.info("Deleting plant with id: " + id);
        Plant plantToDelete = this.service.getPlantById(id);

        if(plantToDelete == null || plantToDelete.getId() <= 0){
            throw new PlantNotFoundException("Plant with id " + id + " doesn't exist !");
        }

        this.service.deletePlantById(id);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePlant(@RequestBody @Valid Plant plant){
        log.info("Plant to update " + plant);
        Plant plantOptional = this.service.getPlantById(plant.getId());

        if(plantOptional == null || plantOptional.getId() <= 0){
            return ResponseEntity.notFound().build();
        }

        this.service.savePlant(plant);

        return ResponseEntity.noContent().build();
    }

    // add Plant validation with BindingResult
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPlant(@RequestBody @Valid Plant plant, HttpServletRequest request){
        log.info("Plant to create " + plant);
        Plant plantToCreate = this.service.getPlantById(plant.getId());

        if(plantToCreate == null || plantToCreate.getId() <= 0){
            throw new PlantNotFoundException("Malformed data !");
        }

        this.service.savePlant(plant);
        URI location = URI.create(request.getRequestURL().toString());
        // ResponseEntity(body, headers, http status code)
        return ResponseEntity.created(location).build();
    }

}