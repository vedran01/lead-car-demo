package com.vbradara.repository;

import com.vbradara.model.LeadDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<LeadDO, Long> {
}
