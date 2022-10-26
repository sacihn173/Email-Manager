package com.assign.emailManager.repositories;

import com.assign.emailManager.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<Users, Long> {
}
