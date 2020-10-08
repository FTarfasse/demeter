package com.fab.demeter.models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "plant")
@DynamicUpdate
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
//    @NotBlank(message = "Name should not be empty.") // validation at controller level
//    @Column(nullable = false) // validation at db level
    @Column(name = "name", nullable = false)
    @Size(min = 1, message = "Name should be at least one character")
    private String name;
    @Column(name = "sow_instructions")
    private String sowInstructions;
    @Column(name = "space_instructions")
    private String spaceInstructions;
    @Column(name = "harvest_instructions")
    private String harvestInstructions;
    @Column(name = "compatible_plants")
    private String compatiblePlants;
    @Column(name = "avoid_instructions")
    private String avoidInstructions;
    @Column(name = "culinary_hints", length = 10000)
    private String culinaryHints;
    @Column(name = "culinary_preservation")
    private String culinaryPreservation;

    public Plant() {
    }

    public Plant(@NotBlank String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSowInstructions() {
        return sowInstructions;
    }

    public void setSowInstructions(String sowInstructions) {
        this.sowInstructions = sowInstructions;
    }

    public String getSpaceInstructions() {
        return spaceInstructions;
    }

    public void setSpaceInstructions(String spaceInstructions) {
        this.spaceInstructions = spaceInstructions;
    }

    public String getHarvestInstructions() {
        return harvestInstructions;
    }

    public void setHarvestInstructions(String harvestInstructions) {
        this.harvestInstructions = harvestInstructions;
    }

    public String getCompatiblePlants() {
        return compatiblePlants;
    }

    public void setCompatiblePlants(String compatiblePlants) {
        this.compatiblePlants = compatiblePlants;
    }

    public String getAvoidInstructions() {
        return avoidInstructions;
    }

    public void setAvoidInstructions(String avoidInstructions) {
        this.avoidInstructions = avoidInstructions;
    }

    public String getCulinaryHints() {
        return culinaryHints;
    }

    public void setCulinaryHints(String culinaryHints) {
        this.culinaryHints = culinaryHints;
    }

    public String getCulinaryPreservation() {
        return culinaryPreservation;
    }

    public void setCulinaryPreservation(String culinaryPreservation) {
        this.culinaryPreservation = culinaryPreservation;
    }
}