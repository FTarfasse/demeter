package com.fab.demeter.repositories;

import com.fab.demeter.models.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

//    @Query("SELECT p FROM Plant p WHERE p.name LIKE %:name%")
//    List<Plant> findPlantNameLike(@Param("name") String name);
    Plant findById(long id);
    void deletePlantById(long id);

//    @Modifying(clearAutomatically = true, flushAutomatically = true)
//    @Query(value = "UPDATE plant p SET  WHERE p.id = :id")
//    void updatePlantById(@Param("")long id);

//    @Query(value = "SELECT p FROM plant p WHERE name LIKE %?1%",
//    countQuery = "SELECT p FROM plant p WHERE name LIKE %?1%")
//    Page<Plant> findPlantNameLike(String name, Pageable pageable);
}
