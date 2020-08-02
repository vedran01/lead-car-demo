package com.vbradara.repository;

import com.vbradara.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDO, Long> {
}
