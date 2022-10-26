package com.assign.emailManager.repositories;

import com.assign.emailManager.models.Email;
import com.assign.emailManager.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailJPARepository extends JpaRepository<Email, Long> {

    @Query(value = "select count(email_id) from Email where received_from = :address",
            nativeQuery = true)
    long countOfEmails(@Param("address") String address);

}
