package com.vbradara.repository;

import com.vbradara.model.CarBrandDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CarBrandRepository extends JpaRepository<CarBrandDO, Long> {
  Set<CarBrandDO> findByNameIn(Set<String> brands);
}
