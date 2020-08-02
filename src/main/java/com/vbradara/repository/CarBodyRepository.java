package com.vbradara.repository;

import com.vbradara.model.CarBodyDO;
import com.vbradara.model.CarBrandDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CarBodyRepository extends JpaRepository<CarBodyDO,Long> {
  Set<CarBodyDO> findByTypeIn(Set<String> brands);
}
