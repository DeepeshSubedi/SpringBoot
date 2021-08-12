package com.deepesh.location.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.deepesh.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
