package com.vbradara.repository;

import com.vbradara.model.CarModelDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CarModelRepository extends JpaRepository<CarModelDO,Long> {
  Set<CarModelDO> findByNameIn(Set<String> brands);
}
