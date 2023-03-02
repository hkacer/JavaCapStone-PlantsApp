package org.pitpitplants.repositories;

import org.pitpitplants.entities.Plant;
import org.pitpitplants.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long>{

}
