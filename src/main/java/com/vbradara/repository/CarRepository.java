package com.vbradara.repository;

import com.vbradara.model.CarDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarDO, Long> {

}
