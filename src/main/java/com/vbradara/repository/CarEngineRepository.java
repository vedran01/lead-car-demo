package com.vbradara.repository;

import com.vbradara.model.CarEngineDO;
import com.vbradara.model.CarModelDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CarEngineRepository extends JpaRepository<CarEngineDO,Long> {
  Set<CarEngineDO> findByTypeIn(Set<String> brands);
}
