package com.vbradara.repository;

import com.vbradara.model.LeadCarDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeadCarRepository extends JpaRepository<LeadCarDO, Long> {

  Optional<LeadCarDO> findByLeadId(Long leadId);

}
