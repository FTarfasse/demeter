package com.fab.demeter;

import com.fab.demeter.models.Plant;
import com.fab.demeter.repositories.PlantRepository;
import com.fab.demeter.services.PlantServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PlantService Unit Tests:")
public class PlantServiceTest {

    @Mock
    private PlantRepository repository;

    @InjectMocks
    private PlantServiceImpl service;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllPlantsTest(){
        List<Plant> plants = new ArrayList<>();
        plants.add(new Plant(1L, "potatoe"));
        plants.add(new Plant(2L, "tomatoe"));
        plants.add(new Plant(3L, "corn"));
        plants.add(new Plant(4L, "marigold"));

        Mockito.when(service.getAllPlants()).thenReturn(plants);
        Assertions.assertEquals(service.getAllPlants().size(), 4);
        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    public void getPlantByIdTest(){
//        Plant sunFlower = new Plant(5L, "sunflower");
//        Mockito.when(this.repository.findById(5L)).thenReturn(sunFlower);
//        Plant result = this.service.getPlantById(5L);

        Mockito.when(this.repository.findById(5L)).thenReturn(new Plant(5L, "sunflower"));
        Plant result = this.repository.findById(5L);                                                                                                                                                                                                                                                                                                                    

        assertThat(result.getId()).isEqualTo(5L);
        assertThat(result.getName()).isEqualTo("sunflower");
        assertThat(result.getCompatiblePlants()).isNull();
    }

    @Test
    public void savePlantTest(){
        Plant apple = new Plant(6L, "apple");
        Mockito.when(this.repository.save(apple)).thenReturn(apple);
        Plant result = this.service.createPlant(apple);

        Assertions.assertEquals(6, result.getId());
        Assertions.assertEquals("apple", result.getName());
    }

    @Test
    public void deletePlantByIdTest(){
        // GIVEN
        Plant banana = new Plant(7L, "banana");
        this.service.deletePlantById(7L);
        // WHEN
//        Mockito.when(this.service.deletePlantById(7L)).then(Optional.of(service.getPlantById(7L)).isEmpty());
        // THEN
        Mockito.verify(this.repository, Mockito.times(1)).deletePlantById(7);
//        assertThat(Optional.of(repository.findById(7L))).is;
    }

}
