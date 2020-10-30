package com.fab.demeter;

import com.fab.demeter.controllers.PlantController;
import com.fab.demeter.models.Plant;
import com.fab.demeter.services.PlantServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
@WebMvcTest(PlantController.class)
public class PlantControllerTest {

//    @Mock
//    private PlantRepository repository;


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlantServiceImpl service;

//    @InjectMocks
//    PlantController controller;

    private List<Plant> plants;

    @BeforeEach
    void setUp(){
        // other option is to set: @RunWith(MockitoJUnitRunner.class)
//        MockitoAnnotations.initMocks(this);
//        List<Plant> plants = Arrays.asList(
//                new Plant("sunflower"),
//                new Plant("marigold"),
//                new Plant("strawberry")
//        );
    }

    @Test
    @DisplayName("GET:/v0/api/plants")
    void should_return_all_plants() throws Exception {
        // GIVEN
        List<Plant> plants = Arrays.asList(
                new Plant(1, "sunflower"),
                new Plant(2,"marigold"),
                new Plant(3,"strawberry")
        );
        // WHEN
        when(this.service.getAllPlants()).thenReturn(plants);
        // THEN
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v0/api/plants")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(plants.get(0).getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(plants.get(0).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].sowInstructions").isEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(plants.get(1).getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value(plants.get(1).getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(plants.get(2).getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].name").value(plants.get(2).getName()));

    }

    @Test
//    @Ignore
    @DisplayName("GET:/v0/api/plants/{id}")
    void getPlantTest() throws Exception {
        // GIVEN
        Plant ficus = new Plant(666,"ficus");
        // WHEN
        when(this.service.getPlantById(666)).thenReturn(ficus);
        // THEN
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v0/api/plants/666")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(ficus.getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(ficus.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sowInstructions").isEmpty());
    }

    @Test
    @DisplayName("DELETE:/v0/api/plants/{id}")
    void should_delete_a_plant_whith_given_id(){
        Assert.fail();
        // GIVEN
        // WHEN
        // THEN
    }

    @Test
    @DisplayName("POST:/v0/api/plants")
    void should_create_a_plant() throws Exception {
        // GIVEN
        Plant elderberry = new Plant("elderberry");
        // WHEN
        when(this.service.createPlant(elderberry)).thenReturn(elderberry);
        // THEN
        this.mockMvc.perform(MockMvcRequestBuilders.post("/v0/api/plants")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(elderberry.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.sowInstructions").isEmpty());
    }

    @Test
    @DisplayName("PATCH:/v0/api/plants/{id}")
    void should_update_a_plant_whith_given_id(){
        Assert.fail();
        // GIVEN
        // WHEN
        // THEN
    }


}
